package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickAnimation(View view) {
        Intent animation = new Intent(MainActivity.this,Animation.class);
        startActivity(animation);
    }
    public void clickImage(View view) {
        Intent image = new Intent(MainActivity.this,Image.class);
        startActivity(image);
    }
    public void clickAudio(View view) {
        Intent audio = new Intent(MainActivity.this,Audio.class);
        startActivity(audio);
    }
    public void clickVideo(View view) {
        Intent video = new Intent(MainActivity.this,Video.class);
        startActivity(video);
    }
    public void clickMusicPlayer(View view) {
        Intent musicPlayer = new Intent(MainActivity.this, MusicPlayer.class);
        startActivity(musicPlayer);
    }
}