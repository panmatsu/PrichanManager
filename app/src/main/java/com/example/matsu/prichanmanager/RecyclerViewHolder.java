package com.example.matsu.prichanmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    public TextView idText;
    public TextView rareText;
    public TextView brandText;
    public TextView kindText;
    public TextView nameText;
    public TextView iineText;
    public TextView holdText;
    public ImageView imageView;

    public RecyclerViewHolder(View itemView){
        super(itemView);

        idText = (TextView) itemView.findViewById(R.id.id);
        rareText = (TextView) itemView.findViewById(R.id.rare);
        brandText = (TextView) itemView.findViewById(R.id.brand);
        kindText = (TextView) itemView.findViewById(R.id.kind);
        nameText = (TextView) itemView.findViewById(R.id.name);
        iineText = (TextView) itemView.findViewById(R.id.iine);
        holdText = (TextView) itemView.findViewById(R.id.hold);
        imageView = (ImageView) itemView.findViewById(R.id.image);

    }
}
