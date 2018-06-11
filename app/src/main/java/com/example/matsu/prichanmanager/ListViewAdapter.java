package com.example.matsu.prichanmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListData>{

    private LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, int resource, List<ListData> objects){
        super(context, resource, objects);
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

        //TextViewとの関連付け
        idText = (TextView)convertView.findViewById(R.id.id);
        rareText = (TextView)convertView.findViewById(R.id.rare);
        brandText = (TextView)convertView.findViewById(R.id.brand);
        kindText = (TextView)convertView.findViewById(R.id.kind);
        nameText = (TextView)convertView.findViewById(R.id.name);
        iineText = (TextView)convertView.findViewById(R.id.iine);

        //TextViewにデータのセット
        idText.setText(data.getId());
        rareText.setText(data.getRare());
        brandText.setText(data.getBrand());
        kindText.setText(data.getKind());
        nameText.setText(data.getName());
        iineText.setText(data.getIine());

        return convertView;
    }
}
