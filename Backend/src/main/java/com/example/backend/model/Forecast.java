package com.example.backend.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Forecast {
    @XmlAttribute(name = "date")
    private Date date;

    @XmlElement(name = "night")
    private Night night;

    @XmlElement(name = "day")
    private Day day;
}
