package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityPart2 extends AppCompatActivity {


    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part2);

        spinner = findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("notebook");
        spinnerArrayList.add("mouse");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

    }





    @SuppressLint("SetTextI18n")
    public void minusQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.num_quantity);
        TextView Price = findViewById(R.id.Price);
        if(quantity>0){
            quantity-=1;
            price-=200;
            quantityTextView.setText(" " + quantity);
            Price.setText(" "+ price);
        }

    }


    @SuppressLint("SetTextI18n")
    public void plusQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.num_quantity);
        TextView Price = findViewById(R.id.Price);
        quantity+=1;
        price+=200;
        quantityTextView.setText(" "+ quantity);
        Price.setText(" "+ price);




    }
}