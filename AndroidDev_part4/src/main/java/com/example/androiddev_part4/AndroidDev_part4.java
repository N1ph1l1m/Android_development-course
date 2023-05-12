package com.example.androiddev_part4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class AndroidDev_part4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_dev_part4);
    }

    public void clickListViewColor(View view) {
        Intent intentListView  = new Intent(AndroidDev_part4.this, colorListView.class);
        startActivity(intentListView);
    }
    public void clickListView(View view) {
        Intent intentListViewColor  = new Intent(AndroidDev_part4.this, activityListView.class);
        startActivity(intentListViewColor);
    }

    public void clickCardView(View view) {
        Intent cardView  = new Intent(AndroidDev_part4.this,cardView.class);
        startActivity(cardView);
    }

    public void clickRecycleView(View view) {
        Intent recycleView  = new Intent(AndroidDev_part4.this,recycleView.class);
        startActivity(recycleView );
    }
}