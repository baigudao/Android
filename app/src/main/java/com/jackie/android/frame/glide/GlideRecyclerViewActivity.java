package com.jackie.android.frame.glide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jackie.android.R;

public class GlideRecyclerViewActivity extends Activity {

    private TextView tv_title;
    private RecyclerView rv_glide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_glide_recycler_view);
        tv_title = (TextView)findViewById(R.id.tv_title);
        rv_glide = (RecyclerView)findViewById(R.id.rv_glide);
    }

    private void initData() {
        tv_title.setText("Glide在RecyclerView中加载图片");

        // 初始化RecyclerView的适配器
        GlideRecyclerViewAdapter glideRecyclerViewAdapter = new GlideRecyclerViewAdapter(this);
        rv_glide.setAdapter(glideRecyclerViewAdapter);
        //设置布局管理
        rv_glide.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
