package com.example.matsu.prichanmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView holdText;
    public ImageView imageView;
    public LinearLayout linearLayout;

    public RecyclerViewHolder(View itemView){
        super(itemView);

        linearLayout = (LinearLayout)itemView.findViewById(R.id.linear_layout);
        holdText = (TextView) itemView.findViewById(R.id.hold);
        imageView = (ImageView) itemView.findViewById(R.id.image);

    }
}
