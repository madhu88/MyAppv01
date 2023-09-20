package com.myapp.weather.model.app;

import lombok.Data;

@Data
public class WeatherByHour {
    private String hour;
    private String weather;
    private String uom;
}
