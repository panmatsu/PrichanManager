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

    public void onBindViewHolder(final RecyclerViewHolder holder, final int position){

        this.position = position;

        //Viewに画像反映
        //Resource番号から画像の貼り付け
        holder.imageView.setImageResource(list.get(position).getResNumber());

        //所持状態なら画像を灰色にする
        if (list.get(position).isHold() == true){
            holder.imageView.setColorFilter(0xaa808080);
        }else{
            holder.imageView.setColorFilter(0xffffff);
        }


        //クリックイベント
        holder.imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //クリック処理
                listener.onClick(view, position);
                //表示更新
                notifyDataSetChanged();

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
        void onClick(View view, int name);
    }
}
