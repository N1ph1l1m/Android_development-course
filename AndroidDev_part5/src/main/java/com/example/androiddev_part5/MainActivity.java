package com.example.androiddev_part5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class  MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PizzaRecipeItem> pizzaRecipeItems = new ArrayList<>();

        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza1),
                Utils.PIZZA_1_TITLE,
                Utils.PIZZA_1_DESCRIPTION,
                Utils.PIZZA_1_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza2),
                Utils.PIZZA_2_TITLE,
                Utils.PIZZA_2_DESCRIPTION,
                Utils.PIZZA_2_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza3),
                Utils.PIZZA_3_TITLE,
                Utils.PIZZA_3_DESCRIPTION,
                Utils.PIZZA_3_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza4),
                Utils.PIZZA_4_TITLE,
                Utils.PIZZA_4_DESCRIPTION,
                Utils.PIZZA_4_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza5),
                Utils.PIZZA_5_TITLE,
                Utils.PIZZA_5_DESCRIPTION,
                Utils.PIZZA_5_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza6),
                Utils.PIZZA_6_TITLE,
                Utils.PIZZA_6_DESCRIPTION,
                Utils.PIZZA_6_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem((R.drawable.pizza7),
                Utils.PIZZA_7_TITLE,
                Utils.PIZZA_7_DESCRIPTION,
                Utils.PIZZA_7_RECIPE));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter = new PizzaRecipeAdapter(pizzaRecipeItems,this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}