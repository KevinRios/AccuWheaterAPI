package com.provincia.clima.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ClimaHourlyJSON {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private String DateTime;

    @JsonProperty("Temperature")
    private Temperature temperature;

    @Getter
    @Setter
    public static class Temperature {
        @JsonProperty("Value")
        private double value;

        @JsonProperty("Unit")
        private String unit;

        @JsonProperty("UnitType")
        private int unitType;

    }

    @JsonProperty("PrecipitationProbability")
    private String PrecipitationProbability;

    private String cityName;
}