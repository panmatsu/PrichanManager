package com.example.matsu.prichanmanager;

import android.content.Context;
import android.util.Log;

public class ListData {

    String id;    //カードID
    String rare;  //レア度
    String brand; //ブランド
    String kind;  //服の種類
    String name;  //名前
    String iine;  //いいね値

    int resNumber; //画像のResource番号

    boolean isHold = false; //所持・未所持



    //IDの設定
    public void setId(String id, Context context){
        //IDの設定
        this.id = id;
        //IDからResource管理番号の設定を行う

        //Log.d("ID::", id.toLowerCase().replace("-","_"));
        this.resNumber = context.getResources().getIdentifier(id.toLowerCase().replace("-", "_"), "drawable", context.getPackageName());
        Log.d("Drawable:",String.valueOf(resNumber));
    }
    //レア度の設定
    public void setRare(String rare) {
        this.rare = rare;
    }
    //ブランドの設定
    public void setBrand(String brand) {
        this.brand = brand;
    }
    //服の種類の設定
    public void setKind(String kind) {
        this.kind = kind;
    }
    //名前の設定
    public void setName(String name) {
        this.name = name;
    }
    //いいね値の設定
    public void setIine(String iine) {
        this.iine = iine;
    }
    //所持パラメータの設定
    public void setIsHold(){
        if(isHold == true){
            this.isHold = false;
        }else{
            this.isHold = true;
        }
    }



    //IDの取得
    public String getId() {
        return id;
    }
    //レア度の取得
    public String getRare() {
        return rare;
    }
    //ブランドの取得
    public String getBrand() {
        return brand;
    }
    //服の種類の取得
    public String getKind() {
        return kind;
    }
    //名前の取得
    public String getName() {
        return name;
    }
    //いいね値の取得
    public String getIine() {
        return iine;
    }
    //Resource管理番号の取得
    public int getResNumber(){
        return resNumber;
    }
    //所持パラメータの取得
    public boolean isHold() {
        return isHold;
    }
}
