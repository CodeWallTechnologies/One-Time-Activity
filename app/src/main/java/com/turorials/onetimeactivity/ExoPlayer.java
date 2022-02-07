package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;


import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.SimpleTimeZone;

public class ExoPlayer extends AppCompatActivity {

    PlayerView player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);


        player = findViewById(R.id.exoplayer_view);
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) new com.google.android.exoplayer2.ExoPlayer.Builder(this).build();

        player.setPlayer(simpleExoPlayer);

        MediaItem mediaItem = MediaItem.fromUri(Uri.parse("https://www.rmp-streaming.com/media/big-buck-bunny-360p.mp4"));
        simpleExoPlayer.setMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();


    }



}