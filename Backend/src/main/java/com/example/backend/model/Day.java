package com.example.backend.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Day {

    @XmlElement(name = "phenomenon")
    private String phenomenon;

    @XmlElement(name = "tempmin")
    private int tempMin;

    @XmlElement(name = "tempmax")
    private int tempMax;

    @XmlElement(name = "text")
    private String text;


    @XmlElement(name = "place")
    private List<Place> places;

    @XmlElement(name = "wind")
    private List<Wind> wind;

    @XmlElement(name = "sea")
    private String sea;

    @XmlElement(name = "peipsi")
    private String peipsi;
}
