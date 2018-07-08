package com.example.matsu.prichanmanager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        //Tabの横スクロール可能
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //Tabを横いっぱいに均一に表示
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setupWithViewPager(viewPager);


    }
}
