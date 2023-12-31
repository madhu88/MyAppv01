package com.myapp;

import android.content.Intent;
import android.net.Uri;
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
        handleButtonClicks(savedInstanceState);
    }

    protected void handleButtonClicks(final Bundle savedInstanceState) {
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent, savedInstanceState);
        });

        Button openGamilButton = findViewById(R.id.openGmail);
        openGamilButton.setOnClickListener(view -> {
            Intent gmailIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/"));
            startActivity(gmailIntent);
        });
    }
}
