package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ReceivedData();
    }
    @SuppressLint("SetTextI18n")
    void ReceivedData(){
        Intent received_orderIntent = getIntent();
        TextView receivedData = findViewById(R.id.receivedUserName);
        //Получаем данные с MainActivityPart2
        String receivedUsersName  = received_orderIntent.getStringExtra("userName");
        String receivedProdName  = received_orderIntent.getStringExtra("prodName");
        int receivedQuantity  = received_orderIntent.getIntExtra("quantity",0);
        double receivedPrice = received_orderIntent.getDoubleExtra("totalPrice",0);
        // Полученные данные присваиваем TextView OrderActivity
        receivedData.setText( receivedUsersName + "\n" + receivedProdName + "\n"+ receivedQuantity + "\n" + receivedPrice);
    }
}