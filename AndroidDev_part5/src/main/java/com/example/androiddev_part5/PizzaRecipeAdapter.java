package com.example.androiddev_part5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PublicKey;


public class PizzaRecipeAdapte extends RecyclerView.Adapter {

    public ImageView pizzaImageView;
    public TextView title;
    public TextView description;
    public ViewGroup viewGroup;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main,viewGroup,false);
        PizzaRecipeViewHolder pizzaRecipeViewHolder = new PizzaRecipeViewHolder(view);
        return pizzaRecipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class  PizzaRecipeViewHolder extends RecyclerView.ViewHolder{
        public PizzaRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
