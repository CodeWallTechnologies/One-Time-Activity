package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutAs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_as);

        getSupportActionBar().setTitle("About As");
    }
}