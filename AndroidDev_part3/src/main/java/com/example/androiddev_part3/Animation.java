package com.example.androiddev_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {
    boolean isVirgilVisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);
    }

   //simple animated
    /*
    public  void hideVirgil(View view){

        if(isVirgilVisible){
            ImageView virgilImage = findViewById(R.id.virgilImageView1);
            ImageView danteImage = findViewById(R.id.danteImageView1);
            virgilImage.animate().alpha(0).setDuration(2000);
            danteImage.animate().alpha(1).setDuration(5000);
            isVirgilVisible = false;
        }
        else {
            ImageView virgilImage = findViewById(R.id.virgilImageView1);
            ImageView danteImage = findViewById(R.id.danteImageView1);
            danteImage.animate().alpha(0).setDuration(2000);
            virgilImage.animate().alpha(1).setDuration(5000);
            isVirgilVisible = true;
        }
    }
    */


    //more animation
    public  void hideVirgil(View view){
        /*
        * roration(360) - оборот в 360 градусов
        * scaleXby(10) & scaleYby(10) уменьшение размера  на 10 пикселей по оси
        * translationXby(10)   - смещение на 10 пикселей в право   & translationXby(-10)  смещение на 10 пикселей влево
         *translationYby(10)  - смещение на 10 пикселей вниз   & translationXby(-10)  смещение на 10 пикселей вверх
         *
         * translationX & translationY смещение на конкретное местоположение
         * */
        if(isVirgilVisible){
            ImageView virgilImage = findViewById(R.id.virgilImageView1);
            ImageView danteImage = findViewById(R.id.danteImageView1);
            virgilImage.animate().rotation(virgilImage.getRotation() + 3600).scaleX(0).scaleY(0).alpha(0).setDuration(2000);
            danteImage.animate().alpha(1).rotation(danteImage.getRotation() + 3600).scaleX(1).scaleY(1).setDuration(3000);
            isVirgilVisible = false;
        }
        else {
            ImageView virgilImage = findViewById(R.id.virgilImageView1);
            ImageView danteImage = findViewById(R.id.danteImageView1);
            danteImage.animate().alpha(0).rotation(danteImage.getRotation() + 3600).scaleX(0).scaleY(0).setDuration(2000);
            virgilImage.animate().alpha(1).rotation(virgilImage.getRotation() + 3600).scaleX(1).scaleY(1).setDuration(3000);
            isVirgilVisible = true;
        }
    }

}


