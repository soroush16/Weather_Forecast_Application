package com.example.backend.service;

import com.example.backend.client.WeatherClient;
import com.example.backend.dto.WeatherResponseDto;
import com.example.backend.model.Forecasts;
import com.example.backend.model.Weather;
import com.example.backend.repository.WeatherRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;


@Service
public class WeatherService {
    private final WeatherRepository repository;
    private final WeatherClient weatherClient;

    private static final Logger logger = LogManager.getLogger(WeatherService.class);

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherClient weatherClient) {
        this.repository = weatherRepository;
        this.weatherClient = weatherClient;
    }


    public ResponseEntity<List<WeatherResponseDto>> findWeatherByCityName(String city) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        LocalDate tomorrow = now.plusDays(1);

        List<Weather> foundWeather = repository.findByCity(city.toLowerCase());

        List<WeatherResponseDto> responseDtoList = foundWeather.stream()
                .filter(weather -> {
                    LocalDate weatherDate = weather.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return weatherDate.isEqual(now) || weatherDate.isEqual(tomorrow);
                })
                .map(weather -> populateResponseDto(dateFormat, weather))
                .toList();

        if (!responseDtoList.isEmpty()) {
            logger.info("The following list was returned to client {} ", responseDtoList);
            return new ResponseEntity<>(responseDtoList, HttpStatus.OK);

        } else {
            logger.info("Object with name {} not found in the database.", city);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Scheduled(fixedRate = 1800000)
    public void save() {
        try {
            Forecasts forecasts = weatherClient.getForecasts();
            var weathers = new HashMap<String, Weather>();

            forecasts.getForecastList().forEach(forecast -> {
                if (forecast.getNight().getPlaces() != null) {

                    forecast.getNight().getPlaces().forEach(place -> {
                        Weather weather = new Weather();
                        weather.setCity(place.getName().toLowerCase());
                        weather.setDate(forecast.getDate());
                        weather.setNightPhenomenon(place.getPhenomenon());
                        weather.setTempMin(place.getTempMin());
                        weathers.put(place.getName(), weather);
                    });
                    forecast.getDay().getPlaces().forEach(place -> {
                        Weather weather = weathers.get(place.getName());
                        weather.setDayPhenomenon(place.getPhenomenon());
                        weather.setTempMax(place.getTempMax());
                        weathers.replace(place.getName(), weather);
                    });
                }
            });
            repository.saveAll(weathers.values());
            // DO Not crash the whole scheduled method for the following Exceptions
        } catch (JAXBException | RestClientException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }

    private WeatherResponseDto populateResponseDto(SimpleDateFormat dateFormat, Weather weather) {
        return WeatherResponseDto.builder()
                .city(weather.getCity())
                .date(dateFormat.format(weather.getDate()))
                .dayPhenomenon(weather.getDayPhenomenon())
                .nightPhenomenon(weather.getNightPhenomenon())
                .tempMax(weather.getTempMax())
                .tempMin(weather.getTempMin())
                .build();
    }


}



