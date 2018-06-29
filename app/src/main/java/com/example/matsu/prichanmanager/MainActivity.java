package com.example.matsu.prichanmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CSVの読み込み
        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext(), "PCH1.csv");

        Log.d("DATASIZE",String.valueOf(parser.objects.size()));

        List<ListData> data = parser.objects;
        //RecyclerViewの反映
        RecyclerView rv = (RecyclerView) findViewById(R.id.RecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setHasFixedSize(true);

        //rv.setLayoutManager(llm);
        rv.setLayoutManager(new GridLayoutManager(this, 3));

        rv.setAdapter(adapter);



    }
}
