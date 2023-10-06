package com.provincia.clima.service;

import com.provincia.clima.entities.ClimaEntity;
import com.provincia.clima.model.ClimaHourlyJSON;
import com.provincia.clima.repository.ClimaRepository;
import com.provincia.clima.utils.ClimaHourlyJSONConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimaPersistenceService {

    @Autowired
    private ClimaRepository climaRepository;
    private final ClimaHourlyJSONConverter climaHourlyJSONConverter;

    @Autowired
    public ClimaPersistenceService(ClimaHourlyJSONConverter climaHourlyJSONConverter) {
        this.climaHourlyJSONConverter = climaHourlyJSONConverter;
    }

    public void saveClimaEntity(List<ClimaHourlyJSON> json) {
        // Convierte los objetos ClimaHourlyJSON en ClimaHourlyJSONEntity si es necesario
        // Luego, guárdalos en la base de datos usando el repositorio
        List<ClimaEntity> entities = climaHourlyJSONConverter.convertToEntities(json);
        climaRepository.saveAll(entities);
    }


}

