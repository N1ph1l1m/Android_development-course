package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayer extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    ImageView pauseIcon;
    Button buttonPlay;
    ImageView imageViewPlay;
    AudioManager audioManager;
    SeekBar volumeSeekBar;
    SeekBar musicSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        pauseIcon = findViewById(R.id.viewPlay);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.stuff2);

        musicSeekBar = findViewById(R.id.seekbarMusic);
        musicSeekBar.setMax(mediaPlayer.getDuration());
        musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                musicSeekBar.setProgress (mediaPlayer.getCurrentPosition());
            }
        },0,1000);
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
    }


    public void musicPlay(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            pauseIcon.setImageResource(R.drawable.play_arrow);
        }else{
            mediaPlayer.start();

            pauseIcon.setImageResource(R.drawable.pause_music);
        }
    }

    public void endMusic(View view){

        musicSeekBar.setProgress(mediaPlayer.getDuration());
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        mediaPlayer.pause();
        pauseIcon.setImageResource(R.drawable.play_arrow);


    }
    public void startMusic(View view){
        musicSeekBar.setProgress(0);
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        pauseIcon.setImageResource(R.drawable.play_arrow);

    }

}