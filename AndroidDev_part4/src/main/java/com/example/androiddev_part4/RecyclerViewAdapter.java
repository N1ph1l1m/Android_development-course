package com.example.androiddev_part4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewViewHolder> {

    private ArrayList<RecyclerViewItem> arrayList;
    public  static class  RecycleViewViewHolder extends  RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public RecycleViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecycleViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);

       RecycleViewViewHolder recycleViewViewHolder = new RecycleViewViewHolder(view);
       return recycleViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewViewHolder recycleViewViewHolder, int position) {
        RecyclerViewItem recyclerViewItem = arrayList.get(position);


        recycleViewViewHolder.imageView.setImageResource(recyclerViewItem.getImageResource());
        recycleViewViewHolder.textView1.setText(recyclerViewItem.getText1());
        recycleViewViewHolder.textView2.setText(recyclerViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
