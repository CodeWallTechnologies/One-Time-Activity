package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFirst;

//     final String fileName = "com.turorials.onetimeactivity.onetime";
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
//        if(!sharedPreferences.getBoolean("firstTime", false)){
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putBoolean("firstTime",Boolean.TRUE);
//            editor.apply();
//        }else{
//                Intent intent = new Intent(MainActivity.this,First.class);
//                startActivity(intent);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst =findViewById(R.id.btn_first);




        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),First.class);
                startActivity(intent);
            }
        });





    }
}