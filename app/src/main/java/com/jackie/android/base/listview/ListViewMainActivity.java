package com.jackie.android.base.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jackie.android.R;

public class ListViewMainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);
        ((TextView) findViewById(R.id.tv_title)).setText("ListView的使用");

        findViewById(R.id.btn_base_use).setOnClickListener(this);
        findViewById(R.id.btn_wrapper).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_base_use:
                startActivity(new Intent(ListViewMainActivity.this, ListViewBaseUseActivity.class));
                break;
            case R.id.btn_wrapper:
                startActivity(new Intent(ListViewMainActivity.this,ListViewWrapperActivity.class));
                break;
            default:
                break;
        }
    }
}
