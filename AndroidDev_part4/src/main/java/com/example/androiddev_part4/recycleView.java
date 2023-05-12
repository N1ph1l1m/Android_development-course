package com.example.androiddev_part4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class recycleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.android_blue,"Nill Angus","Simple text - just to fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.android_red,"Marlie Pandes","Simple text 2  - just to fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.android_green,"Milkolm Venus","Hells bells"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.android_blue,"Nill Fuiry","Simple text - just to fun"));
    }
}