package com.example.matsu.prichanmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    //TabのTitle
    private CharSequence[] tabTiles = {"第一弾", "第二弾"};


    public CustomFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTiles[position];
    }

    @Override
    public Fragment getItem(int position){
        //Fragmentを初期化し、引数にタブ番号＋１
        return MainFragment.newInstance(position + 1);
    }

    @Override
    public int getCount(){
        return tabTiles.length;
    }
}
