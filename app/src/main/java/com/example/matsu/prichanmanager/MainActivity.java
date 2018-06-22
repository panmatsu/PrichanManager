package com.example.matsu.prichanmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CSVの読み込み
        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext(), "PCH1.csv");
        final ListViewAdapter listViewAdapter = new ListViewAdapter(this, 0, parser.objects);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                ListView list = (ListView)adapterView;
                ListData data = (ListData) list.getItemAtPosition(pos);
                //所持データの更新
                data.setIsHold();
                //所持テキストの更新
                listViewAdapter.notifyDataSetChanged();
            }
        });

    }
}
