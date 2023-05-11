package com.example.androiddev_part4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AndroidDev_part4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_dev_part4);

        ListView listView = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<20; i++){
            list.add("Post" + i);
            Log.i("list" , list.get(i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter((arrayAdapter));
    }

}