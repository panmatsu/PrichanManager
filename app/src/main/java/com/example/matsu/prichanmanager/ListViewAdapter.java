package com.example.matsu.prichanmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListData>{

    private LayoutInflater layoutInflater;

    private Context context;

    public ListViewAdapter(Context context, int resource, List<ListData> objects){
        super(context, resource, objects);

        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ListData data = (ListData)getItem(position);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView idText;
        TextView rareText;
        TextView brandText;
        TextView kindText;
        TextView nameText;
        TextView iineText;
        TextView holdText;
        ImageView imageView;

        //各Viewとの関連付け
        idText = (TextView)convertView.findViewById(R.id.id);
        holdText = (TextView)convertView.findViewById(R.id.hold);
        imageView = (ImageView)convertView.findViewById(R.id.image);

        //TextViewにデータのセット
        idText.setText(data.getId());
        if(data.isHold() == true){
            holdText.setText("所持");
        }else{
            holdText.setText("未所持");
        }


        //Resource番号から画像の貼り付け
        if(data.resNumber != 0) {
            imageView.setImageResource(data.getResNumber());
        }else{
            imageView.setImageResource(R.drawable.pch1_01);
        }
        return convertView;
    }
}
