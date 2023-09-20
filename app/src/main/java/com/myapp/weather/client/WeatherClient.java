package com.myapp.weather.client;

import android.util.Log;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.myapp.weather.model.client.WeatherResponse;


import java.io.IOException;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class WeatherClient implements Callable<WeatherResponse> {

    WeatherResponse weatherResponse = null;

    private static volatile WeatherClient INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService weatherClientThread =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WeatherClient getWeatherClient() {
        if (INSTANCE == null) {
            synchronized (WeatherClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WeatherClient();
                }
            }
        }
        return INSTANCE;
    }

    public WeatherResponse callWeatherClient() {
        String weatherAPIUrl = "https://api.open-meteo.com/v1/forecast?latitude=51.4015&longitude=-1.3247&hourly=temperature_2m&forecast_days=1";
        try {
            URL weatherApiUrl = new URL(weatherAPIUrl);
            HttpsURLConnection weatherApiConnection =
                    (HttpsURLConnection) weatherApiUrl.openConnection();
            if (weatherApiConnection.getResponseCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                weatherResponse = objectMapper.readValue(weatherApiConnection.getInputStream(), WeatherResponse.class);
                Log.d("response = ", weatherResponse.toString());
            }
        } catch (MalformedURLException e) {
            Log.e("MalformedURLException ", "ex", e);
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            Log.e("IOException ", "ex", e);
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception ", "ex", e);
        }
        return weatherResponse;
    }


    @Override
    public WeatherResponse call() {
        return callWeatherClient();
    }

    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }
}
