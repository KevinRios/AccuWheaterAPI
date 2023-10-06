package com.provincia.clima.interfaces;

import com.provincia.clima.model.ClimaHourlyJSON;

import java.util.List;

public interface IClima {

    List<ClimaHourlyJSON> getHourlyForecast(String cityKey);

}
