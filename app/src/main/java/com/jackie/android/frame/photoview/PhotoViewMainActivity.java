package com.jackie.android.frame.photoview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.android.R;

public class PhotoViewMainActivity extends Activity implements View.OnClickListener {

    private TextView tv_title;
    private Button btn_photo_view_base;
    private Button btn_photo_view_viewPager;
    private Button btn_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initListener() {
        btn_photo_view_base.setOnClickListener(this);
        btn_photo_view_viewPager.setOnClickListener(this);
        btn_reference.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_photo_view_main);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("PhotoView的使用");
        btn_photo_view_base = (Button) findViewById(R.id.btn_photo_view_base);
        btn_photo_view_viewPager = (Button) findViewById(R.id.btn_photo_view_viewPager);
        btn_reference = (Button) findViewById(R.id.btn_reference);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_photo_view_base:
                startActivity(new Intent(this, PhotoViewBaseUseActivity.class));
                break;
            case R.id.btn_photo_view_viewPager:
                startActivity(new Intent(this, PhotoViewViewPagerActivity.class));
                break;
            case R.id.btn_reference:
                startActivity(new Intent(this, PhotoViewReferenceActivity.class));
                break;
            default:
                break;
        }
    }
}
