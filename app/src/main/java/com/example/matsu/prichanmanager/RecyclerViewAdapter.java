package com.example.matsu.prichanmanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private int position;
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

        this.position = position;
        //Viewにテキスト反映
        if(list.get(position).isHold() == true){
            holder.holdText.setText("所持");
        }else{
            holder.holdText.setText("未所持");
        }
        //Viewに画像反映
        //Resource番号から画像の貼り付け
        holder.imageView.setImageResource(list.get(position).getResNumber());


        //クリックイベント
        holder.linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                list.get(position).setIsHold();
                notifyDataSetChanged();
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
