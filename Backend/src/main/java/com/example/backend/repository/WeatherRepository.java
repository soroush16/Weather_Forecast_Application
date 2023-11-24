package com.example.backend.repository;


import com.example.backend.model.Weather;
import com.example.backend.model.WeatherId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeatherRepository extends JpaRepository<Weather, WeatherId> {
    List<Weather> findByCity(String city);

}
