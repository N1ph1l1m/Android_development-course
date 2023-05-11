package com.example.androiddev_part4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class colorListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_color_list_view);

        ListView listView = findViewById(R.id.listViewColor);

        ArrayList<String> colorlistView = new ArrayList<>();

        colorlistView.add("Красный");
        colorlistView.add("Оранжевый");
        colorlistView.add("Желтый");
        colorlistView.add("Зеленый");
        colorlistView.add("Голубой");
        colorlistView.add("Синий");
        colorlistView.add("Фиолетовый");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,colorlistView);
        listView.setAdapter((arrayAdapter));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(colorListView.this, "Test" + position + " - " + colorlistView.get(position), Toast.LENGTH_SHORT).show();

            }
        });
    }
}