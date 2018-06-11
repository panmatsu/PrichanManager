package com.example.matsu.prichanmanager;

public class ListData {

    String id;    //カードID
    String rare;  //レア度
    String brand; //ブランド
    String kind;  //服の種類
    String name;  //名前
    String iine;  //いいね値



    //IDの設定
    public void setId(String id){
        this.id = id;
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
}
