package com.example.backend.client;

import com.example.backend.model.Forecasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;

@Component
public class WeatherClient {

    private final String apiUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherClient(@Value("${api.url}") String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    public Forecasts getForecasts() throws JAXBException, NullPointerException {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        JAXBContext jaxbContext = JAXBContext.newInstance(Forecasts.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ByteArrayInputStream input = new ByteArrayInputStream(response.getBody().getBytes());
        return (Forecasts) jaxbUnmarshaller.unmarshal(input);
    }
}
