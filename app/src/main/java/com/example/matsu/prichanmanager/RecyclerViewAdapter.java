package com.example.matsu.prichanmanager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    //表示リストデータ
    private List<ListData> list;
    private onItemClickListener listener;

    public RecyclerViewAdapter(List<ListData> list){
        this.list = list;
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerViewHolder vh = new RecyclerViewHolder(inflate);
        return vh;
    }

    public void onBindViewHolder(RecyclerViewHolder holder, final int position){

        //Viewにテキスト反映
        holder.idText.setText(list.get(position).getId());
        if(list.get(position).isHold() == true){
            holder.holdText.setText("所持");
        }else{
            holder.holdText.setText("未所持");
        }
        Log.d("Name", list.get(position).getName());
        //Viewに画像反映
        //Resource番号から画像の貼り付け
        if(list.get(position).resNumber != 0) {
            holder.imageView.setImageResource(list.get(position).getResNumber());
        }else{
            holder.imageView.setImageResource(R.drawable.pch1_01);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onClick(view, list.get(position).getName());
            }
        });
    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }

    public int getItemCount(){
        return list.size();
    }

    public interface onItemClickListener{
        void onClick(View view, String name);
    }
}
