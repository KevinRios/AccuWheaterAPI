package com.provincia.clima.interfaces;

import com.provincia.clima.model.CityInfoJSON;

import java.util.List;

public interface ICityKey {

    List<CityInfoJSON> getCityKey(String cityName);

}
