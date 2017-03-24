package com.jackie.android.frame.glide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jackie.android.R;

public class GlideTransformationActivity extends Activity {

    private TextView tvTitle;
    private RecyclerView rvGlideTransformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_glide_transformation);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        rvGlideTransformations = (RecyclerView) findViewById(R.id.rv_glide_transformations);
    }

    private void initData() {
        tvTitle.setText("Glide图形变换");

        // 初始化RecyclerView的适配器
        GlideTransformationAdapter glideTransformationAdapter = new GlideTransformationAdapter(this);
        rvGlideTransformations.setAdapter(glideTransformationAdapter);
        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
