package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Audio extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        button = findViewById(R.id.buttonStart);
        button.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                      pause();
                }else{
                    start();
                }
            }
        });

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.stuff2);
    }
    boolean play_audio = true;
    public void start() {
        mediaPlayer.start();
        button.setText("Pause");
    }

    public void pause() {
        mediaPlayer.pause();
        button.setText("Play");
    }
}