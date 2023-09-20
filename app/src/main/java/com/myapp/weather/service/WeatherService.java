package com.myapp.weather.service;

import android.util.Log;

import com.myapp.weather.client.WeatherTask;
import com.myapp.weather.model.client.WeatherResponse;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class WeatherService {

    public static WeatherResponse getWeatherDetails() {
        Future<WeatherResponse> weatherTaskFuture =
                WeatherTask.weatherClientThread.submit(WeatherTask.getWeatherTask());
        try {
            WeatherResponse weatherResponse = weatherTaskFuture.get();
            Log.d("Res in service = ", weatherResponse.toString());
            return weatherResponse;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
