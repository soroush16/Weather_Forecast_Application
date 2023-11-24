package com.example.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherResponseDto {
    private String city;
    private String date;
    private String dayPhenomenon;
    private String nightPhenomenon;
    private Integer tempMax;
    private Integer tempMin;

}
