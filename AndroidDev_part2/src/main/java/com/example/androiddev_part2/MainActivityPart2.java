package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

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

    public void minusQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.num_quantity);
        if(quantity>0){
            quantity=quantity-1;
            quantityTextView.setText(" " + quantity);
        }

    }


    public void plusQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.num_quantity);
        quantity=quantity+1;
        quantityTextView.setText(" "+ quantity);



    }
}