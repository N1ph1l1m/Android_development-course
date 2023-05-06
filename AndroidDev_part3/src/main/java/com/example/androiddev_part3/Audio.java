package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Audio extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.stuff2);
    }
    boolean play_audio = true;
    public void clickStart(View view) {
        mediaPlayer.start();
    }

    public void clickPause(View view) {
        mediaPlayer.pause();
    }
}