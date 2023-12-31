package com.provincia.clima.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ClimaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;

    private Double temperature;

    private String precipitationProbability;

    private LocalDateTime dateTime;


}
