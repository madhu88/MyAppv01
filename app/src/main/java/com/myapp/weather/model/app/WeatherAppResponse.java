package com.myapp.weather.model.app;

import java.util.Set;

import lombok.Data;

@Data
public class WeatherAppResponse {
    private Set<WeatherByHour> weatherByHourSet;
}
