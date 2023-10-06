package com.provincia.clima.utils;

import com.provincia.clima.entities.ClimaEntity;
import com.provincia.clima.model.ClimaHourlyJSON;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClimaHourlyJSONConverter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");


    public static List<ClimaEntity> convertToEntities(List<ClimaHourlyJSON> climaHourlyJSONList) {
       return climaHourlyJSONList.stream()
                .map(ClimaHourlyJSONConverter::convertToEntity)
               .collect(Collectors.toList());

     }


    public static ClimaEntity convertToEntity(ClimaHourlyJSON climaHourlyJSON) {
        ClimaEntity entity = new ClimaEntity();
        entity.setCityName(climaHourlyJSON.getCityName());
        entity.setDateTime(LocalDateTime.parse(climaHourlyJSON.getDateTime(), DATE_TIME_FORMATTER));
        entity.setTemperature(climaHourlyJSON.getTemperature().getValue());
        entity.setPrecipitationProbability(climaHourlyJSON.getPrecipitationProbability());

        return entity;
    }
}
