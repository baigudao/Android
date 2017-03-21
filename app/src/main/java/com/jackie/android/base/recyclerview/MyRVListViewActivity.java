package com.jackie.android.base.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jackie.android.R;

import java.util.ArrayList;
import java.util.List;

public class MyRVListViewActivity extends Activity {

    private RecyclerView recycler_view;
    private List<String> strings = new ArrayList<>();
    private MyRVListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rvlist_view);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        //准备数据
        initData();
        //定义adapter
        adapter = new MyRVListViewAdapter(this, strings);
        //设置适配器
        recycler_view.setAdapter(adapter);
        //设置布局管理器
        /**
         * 1，上下文
         * 2，布局方向
         * 3，是否倒序排列
         */
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            strings.add("我厉害吧！ " + i);
        }
    }
}
