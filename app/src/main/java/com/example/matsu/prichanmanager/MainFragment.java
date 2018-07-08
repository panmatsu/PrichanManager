package com.example.matsu.prichanmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainFragment extends Fragment {

    //RecyclerView
    private RecyclerView mRecyclerView = null;
    //Adapter
    private RecyclerViewAdapter mAdapter = null;

    //第何弾か
    private int position;

    //外部からの初期化メソッド
    static MainFragment newInstance(int pos){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        //タブ番号をして、Bundleに紐づけ
        args.putInt("POSITION", pos);
        fragment.setArguments(args);
        return fragment;
    }

    //空のコンストラクタの用意
    public MainFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        //BundleからPosition(タブ番号)を受け取る
        Bundle bundle = getArguments();
        position = bundle.getInt("POSITION");

        //基本レイアウト
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //RecyclerViewの参照を取得
        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceInstate){
        super.onViewCreated(view, savedInstanceInstate);


        //CSVの読み込み
        CsvReader parser = new CsvReader();
        parser.reader(getContext(), "PCH"+String.valueOf(position)+".csv");

        //１番目のコーデの画像が読み込めない不具合のため個別代入
        switch (position){
            case 1:
                parser.objects.get(0).resNumber = R.drawable.pch1_01;
                break;
            case 2:
                parser.objects.get(0).resNumber = R.drawable.pch2_01;
                break;
        }


        //****RecyclerViewの設定****
        //データのセット
        mAdapter = new RecyclerViewAdapter(parser.objects);
        //RecyclerViewのサイズを維持し続ける
        mRecyclerView.setHasFixedSize(true);
        //Adapterのセット
        mRecyclerView.setAdapter(mAdapter);

        //クリック処理
        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, String name) {
                Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
