package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFirst,btnSecond,btnThird,btnFourth,btn_exoPlayer,btn_cheat_sheet;

//     final String fileName = "com.turorials.onetimeactivity.onetime";

//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
//        if(!sharedPreferences.getBoolean("firstTime", false)){
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putBoolean("firstTime",Boolean.TRUE);
//            editor.apply();
//        }else{
//                Intent intent = new Intent(MainActivity.this,Second.class);
//                startActivity(intent);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecond = findViewById(R.id.btn_second);
        btnThird =  findViewById(R.id.btn_third);
        btnFirst =findViewById(R.id.btn_first);
        btnFourth = findViewById(R.id.btn_fourth);
        btn_exoPlayer = findViewById(R.id.btn_exo_player);
        btn_cheat_sheet = findViewById(R.id.btn_cheat_sheet);



        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second.class);
                startActivity(intent);
            }
        });


        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Third.class);
                startActivity(intent);
            }
        });


        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),First.class);
                startActivity(intent);
            }
        });


        btnFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Fourth.class);
                startActivity(intent);
            }
        });


        btn_exoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExoPlayer.class);
                startActivity(intent);
            }
        });


        btn_cheat_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShortCutActivity.class);
                startActivity(intent);
            }
        });

    }
}