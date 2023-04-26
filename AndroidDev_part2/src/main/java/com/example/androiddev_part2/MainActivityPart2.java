package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class MainActivityPart2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part2);
    }


    int quantity = 0;
    int price = 0;


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