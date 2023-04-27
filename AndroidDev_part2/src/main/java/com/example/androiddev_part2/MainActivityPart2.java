package com.example.androiddev_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
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
    String productsName;
    double priceProd;
    EditText userNameEditText;

    void OnCreateSpinner(){
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

    }

    void OnCreateHashMap(){
        priceHashMap = new HashMap();
        priceHashMap.put("notebook",2000.0);
        priceHashMap.put("mouse",15.0);
        priceHashMap.put("keyboard", 10.0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_part2);
        userNameEditTest.findViewById(R.id.userNameEditText);
        OnCreateSpinner();
        OnCreateHashMap();

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
        ImageView productImg = findViewById(R.id.productImg);
        TextView descriptionProd = findViewById(R.id.descriptionProd);

        switch (productsName){
            case("notebook"):
                productImg.setImageResource(R.drawable.notebook);
                descriptionProd.setText("A notebook is a portable computer designed for personal use. It typically has a thin LCD or LED computer screen mounted on the inside of the upper lid of the clamshell form factor. The screen can be folded down to protect the keyboard and other components when the notebook is not in use. Notebooks are designed to be lightweight and easy to carry, and are often used by students, business people, and anyone who needs a computer that can be taken on the go.");
                break;
            case("mouse"):
                productImg.setImageResource(R.drawable.mouse);
                descriptionProd.setText("A computer mouse is an input device used to control the cursor on a computer screen. It is typically a small handheld device that is moved across a flat surface, such as a mouse pad or desk, to control the movement of the cursor on the screen. A computer mouse usually has at least two buttons and a scrolling wheel, which can be used to perform various functions on the computer, such as selecting and opening files, scrolling through documents, and clicking on links");
                break;
            case("keyboard"):
                productImg.setImageResource(R.drawable.keyboard);
                descriptionProd.setText("A keyboard for a PC is a peripheral device that is used to input text and commands into a computer. Here are some common types of PC keyboards:");
                break;
        }
    }

    public void createOrder(View view){

        Order order = new Order();
        order.username = userNameEditText.getText().toString();


    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}