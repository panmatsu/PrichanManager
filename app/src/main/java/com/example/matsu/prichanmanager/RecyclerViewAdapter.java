package com.example.matsu.prichanmanager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<ListData> list;

    public RecyclerViewAdapter(List<ListData> list){
        this.list = list;
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerViewHolder vh = new RecyclerViewHolder(inflate);
        return vh;
    }

    public void onBindViewHolder(RecyclerViewHolder holder, int position){

        //Viewにテキスト反映
        holder.idText.setText(list.get(position).getId());
        holder.rareText.setText(list.get(position).getRare());
        holder.brandText.setText(list.get(position).getBrand());
        holder.kindText.setText(list.get(position).getKind());
        holder.nameText.setText(list.get(position).getName());
        holder.iineText.setText(list.get(position).getIine());
        if(list.get(position).isHold() == true){
            holder.holdText.setText("所持");
        }else{
            holder.holdText.setText("未所持");
        }
        Log.d("Name", list.get(position).getName());
        //Viewに画像反映
        holder.iineText.setText(String.valueOf(list.get(position).resNumber));
        //Resource番号から画像の貼り付け
        if(list.get(position).resNumber != 0) {
            holder.imageView.setImageResource(list.get(position).getResNumber());
        }else{
            holder.imageView.setImageResource(R.drawable.pch1_01);
        }
    }

    public int getItemCount(){
        return list.size();
    }
}
