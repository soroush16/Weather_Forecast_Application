package com.example.backend.controller;

import com.example.backend.dto.WeatherResponseDto;
import com.example.backend.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weather) {
        this.weatherService = weather;
    }


    @GetMapping
    public ResponseEntity<List<WeatherResponseDto>> findWeatherByCityName(@RequestParam String city) {
        return weatherService.findWeatherByCityName(city);
    }
}
