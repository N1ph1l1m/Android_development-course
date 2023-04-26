package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityPart2 extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    ArrayList<String> spinnerArrayList;
    ArrayAdapter<String> spinnerAdapter;
    HashMap<String, Double> priceHashMap;
    int quantity = 0;
//    int price = 0;
    String productsName;
    double priceProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part2);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList<>();

        spinnerArrayList.add("notebook");
        spinnerArrayList.add("mouse");
        spinnerArrayList.add("keyboard");

        //Событие для спинера с добавление ArrayList
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        priceHashMap = new HashMap();
        priceHashMap.put("notebook",2000.0);
        priceHashMap.put("mouse",15.0);
        priceHashMap.put("keyboard", 10.0);



    }
    @SuppressLint("SetTextI18n")
    public void minusQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.num_quantity);
        if(quantity>0){
            quantity-=1;
            quantityTextView.setText(" " + quantity);
            TextView Price = findViewById(R.id.Price);
            Price.setText("" + quantity  * priceProd);

        }

    }
    @SuppressLint("SetTextI18n")
    public void plusQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.num_quantity);
        quantity+=1;
        quantityTextView.setText(" "+ quantity);
        TextView Price = findViewById(R.id.Price);
        Price.setText("" + quantity  * priceProd);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        productsName = spinner.getSelectedItem().toString();
        priceProd = (double) priceHashMap.get(productsName);
        TextView Price = findViewById(R.id.Price);
        Price.setText("" + quantity  * priceProd);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}