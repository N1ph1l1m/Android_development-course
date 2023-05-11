package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MusicPlayer extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    Button buttonPlay;
    AudioManager audioManager;
    SeekBar volumeSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        buttonPlay = findViewById(R.id.buttonPlay);
        volumeSeekBar = findViewById(R.id.seekbarVolume);
        volumeSeekBar.setMax(maxVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Progress changed:",  "" + progress);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        buttonPlay.setOnClickListener( new View.OnClickListener(){
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
    public void start() {
        mediaPlayer.start();
        buttonPlay.setText("Pause");
    }

    public void pause() {
        mediaPlayer.pause();
        buttonPlay.setText("Play");
    }

}