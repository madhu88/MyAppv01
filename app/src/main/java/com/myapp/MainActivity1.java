package com.myapp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.P)
public class MainActivity1 extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
