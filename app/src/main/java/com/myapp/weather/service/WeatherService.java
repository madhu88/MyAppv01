package com.myapp.weather.service;

import android.util.Log;

import com.myapp.weather.client.WeatherClient;
import com.myapp.weather.model.client.WeatherResponse;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class WeatherService {

    public static WeatherResponse getWeatherDetails() {
        Future<WeatherResponse> weatherClientFuture =
                WeatherClient.weatherClientThread.submit(WeatherClient.getWeatherClient());
        try {
            WeatherResponse weatherResponse = weatherClientFuture.get();
            Log.d("Res in service = ", weatherResponse.toString());
            return weatherResponse;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
