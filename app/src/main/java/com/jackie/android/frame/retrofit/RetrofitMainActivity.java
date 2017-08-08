package com.jackie.android.frame.retrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jackie.android.R;

public class RetrofitMainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);
        ((TextView) findViewById(R.id.tv_title)).setText("Retrofit的基本使用");

        findViewById(R.id.btn_base_use).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base_use:
                startActivity(new Intent(RetrofitMainActivity.this, RetrofitBaseUseActivity.class));
                break;
            default:
                break;
        }
    }
}
