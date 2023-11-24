package com.example.backend.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Place {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "phenomenon")
    private String phenomenon;
    @XmlElement(name = "tempmin")
    private Integer tempMin;
    @XmlElement(name = "tempmax")
    private Integer tempMax;

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", phenomenon='" + phenomenon + '\'' +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }
}
