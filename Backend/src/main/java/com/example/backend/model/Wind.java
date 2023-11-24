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
public class Wind {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "direction")
    private String direction;

    @XmlElement(name = "speedmin")
    private Integer speedMin;

    @XmlElement(name = "speedmax")
    private InternalError speedMax;

    @XmlElement(name = "gust")
    private Integer gust;

}
