package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Audio extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button;
    SeekBar volumeSeekBar;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        button = findViewById(R.id.buttonStart);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
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