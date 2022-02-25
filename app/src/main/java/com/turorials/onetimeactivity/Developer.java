package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class Developer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        getSupportActionBar().setTitle("Profiles");
        Button follow , message;

        follow = findViewById(R.id.dev_follow);
        message = findViewById(R.id.dev_message);

        follow.setOnClickListener(v -> {
            Intent intent = null;
            try{
                intent =new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100053328015007"));
            }catch (Exception e){
                Log.e("TAG", "Application not installed.");
                //Open url web page.
                intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/khat.y.nwe/"));
            }
            startActivity(intent);
        });
        message.setOnClickListener(v -> {
            Intent intent = null;
            try{
                intent =new Intent(Intent.ACTION_VIEW, Uri.parse("fb-messenger://user/100053328015007"));
            }catch (Exception e){
                Log.e("TAG", "Application not installed.");
                //Open url web page.
                intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/messages/t/100053328015007/"));
            }
            startActivity(intent);
            Toast.makeText(Developer.this, "Success", Toast.LENGTH_SHORT).show();

        });

    }
}