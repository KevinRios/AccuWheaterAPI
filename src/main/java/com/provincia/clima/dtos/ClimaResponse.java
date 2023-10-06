package com.provincia.clima.dtos;

import com.provincia.clima.model.ClimaHourlyJSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ClimaResponse {
    private String mensaje;
    private List<ClimaHourlyJSON> climaHourlyData;

}
