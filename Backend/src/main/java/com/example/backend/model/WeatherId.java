package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class WeatherId implements Serializable {
    private String city;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherId weatherId = (WeatherId) o;
        return city.equals(weatherId.city) && date.equals(weatherId.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, date);
    }
}
