package com.example.androiddev_part4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activityListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.listSimple);

        ArrayList<String> simplelistView = new ArrayList<>();
        for(int i = 0; i<20 ; i++){
            simplelistView.add("Post" + i);
            Log.i("post", simplelistView.get(i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,simplelistView);
        listView.setAdapter((arrayAdapter));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activityListView.this, "Test", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
