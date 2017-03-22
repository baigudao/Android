package com.jackie.android.base.recyclerview.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jackie.android.R;

import java.util.ArrayList;
import java.util.List;

public class MyRVGridViewActivity extends Activity {

    private RecyclerView recycler_view;
    private List<String> strings = new ArrayList<>();
    private MyRVGridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rvgrid_view);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        //准备数据
        initData();
        //自定义adapter
        adapter = new MyRVGridViewAdapter(this, strings);
        //设置适配器
        recycler_view.setAdapter(adapter);
        //设置布局管理器
        recycler_view.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            strings.add("哈哈... " + i);
        }
    }
}
