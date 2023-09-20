package com.myapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.annotation.RequiresApi;

import com.myapp.activities.SecondActivity;

@RequiresApi(api = Build.VERSION_CODES.P)
public class MainActivity1 extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("in onCreate", "started app for first time");
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.nextButton);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent, savedInstanceState);
        });
    }
}
