package com.example.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weather")
@IdClass(WeatherId.class)
public class Weather {
    @Id
    private String city;
    @Id
    @Column(columnDefinition = "date")
    private Date date;
    private String dayPhenomenon;
    private String nightPhenomenon;
    private Integer tempMax;
    private Integer tempMin;
}
