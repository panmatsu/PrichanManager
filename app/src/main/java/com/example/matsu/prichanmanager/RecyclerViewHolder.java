package com.example.matsu.prichanmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public RecyclerViewHolder(View itemView){
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.image);

    }
}
