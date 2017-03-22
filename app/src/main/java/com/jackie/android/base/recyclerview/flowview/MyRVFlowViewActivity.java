package com.jackie.android.base.recyclerview.flowview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jackie.android.R;

import java.util.ArrayList;
import java.util.List;

public class MyRVFlowViewActivity extends Activity {

    private RecyclerView recycler_view;
    private List<String> strings = new ArrayList<>();
    private MyRVFlowViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rvflow_view);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        initData();
        adapter = new MyRVFlowViewAdapter(this, strings);
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            strings.add("呵呵... " + i);
        }
    }
}
