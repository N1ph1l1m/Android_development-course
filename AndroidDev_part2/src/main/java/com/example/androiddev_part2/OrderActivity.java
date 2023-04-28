package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class OrderActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ReceivedData();
    }

    @SuppressLint("SetTextI18n")
    void ReceivedData(){
        Intent received_orderIntent = getIntent();
        TextView UserName = findViewById(R.id.receivedUserName);
        TextView ProductName = findViewById(R.id.receivedproductName);
        TextView Quantity = findViewById(R.id.receivedQuantity);
        TextView Price = findViewById(R.id.receivedPrice);
        TextView OrderPrice = findViewById(R.id.receivedOrderPrice);

        //Получаем данные с MainActivityPart2
        String receivedUsersName  = received_orderIntent.getStringExtra("userName");
        String receivedProdName  = received_orderIntent.getStringExtra("prodName");
        int receivedQuantity  = received_orderIntent.getIntExtra("quantity",0);
        double receivedPrice = received_orderIntent.getDoubleExtra("price",0);
        double receivedOrderPrice = received_orderIntent.getDoubleExtra("totalPrice",0);

        // Полученные данные присваиваем TextView OrderActivity
            UserName.setText(receivedUsersName);
            ProductName.setText(receivedProdName);
            Quantity.setText("" + receivedQuantity);
            Price.setText("" + receivedPrice);
            OrderPrice.setText("" + receivedOrderPrice);
        }
}