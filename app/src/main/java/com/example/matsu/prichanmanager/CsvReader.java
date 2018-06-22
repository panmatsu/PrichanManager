package com.example.matsu.prichanmanager;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.matsu.prichanmanager.ListData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader{

    List<ListData> objects = new ArrayList<ListData>();

    public  void reader(Context context, String csvFile){
        AssetManager assetManager = context.getResources().getAssets();
        try{
            //CSVファイルの読み込み
            InputStream inputStream = assetManager.open(csvFile);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;

            while((line = bufferedReader.readLine()) != null){
                //カンマ区切りで１つずつ配列に入れる
                ListData data = new ListData();
                String[] RowData = line.split(",");

                //CSVを順にセット
                data.setId(RowData[0], context);    //ID
                data.setRare(RowData[1]);  //レア度
                data.setBrand(RowData[2]); //ブランド
                data.setKind(RowData[3]);  //服の種類
                data.setName(RowData[4]);  //名前
                data.setIine(RowData[5]);  //いいね値

                objects.add(data);
            }
            bufferedReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}