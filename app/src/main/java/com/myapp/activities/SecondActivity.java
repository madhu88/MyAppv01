package com.myapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

import com.myapp.R;
import com.myapp.weather.model.client.WeatherResponse;
import com.myapp.weather.service.WeatherService;

import java.util.List;

public class SecondActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("in onCreate", "started app for first time ever");
        setContentView(R.layout.activity_second);
        populateTextData();
    }

    private void populateTextData() {
        WeatherResponse weatherResponse = WeatherService.getWeatherDetails();

        TableLayout tableLayout = findViewById(R.id.weatherTable);

        for (int i = 0; i < weatherResponse.getHourly().getTime().size(); i++) {
            TableRow tableRow = new TableRow(tableLayout.getContext());
            TextView hourTextView = new TextView(tableLayout.getContext());
            TextView tempTextView = new TextView(tableLayout.getContext());
            hourTextView.setText(weatherResponse.getHourly().getTime().get(i));
            hourTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tempTextView.setText(String.valueOf(
                    weatherResponse.getHourly().getTemperature2m().get(i)));
            tempTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tableRow.addView(hourTextView);
            tableRow.addView(tempTextView);
            tableRow.setBackgroundColor(Color.parseColor("#DAE8FC"));
            tableLayout.addView(tableRow);
        }
    }
}
