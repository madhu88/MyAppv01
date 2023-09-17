package com.myapp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.P)
public class MainActivity1 extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("in onCreate", "started app for first time ever");
        setContentView(R.layout.activity_main);
        populateTextData();
    }

    private void populateTextData() {
        TextView textView = findViewById(R.id.helloText);
        Date date = Calendar.getInstance().getTime();
        textView.setText(date.toString());
    }
}
