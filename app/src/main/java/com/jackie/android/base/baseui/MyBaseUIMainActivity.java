package com.jackie.android.base.baseui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jackie.android.R;
import com.jackie.android.base.baseui.button.ButtonMainActivity;
import com.jackie.android.base.baseui.dialog.DialogMainActivity;
import com.jackie.android.base.baseui.searchview.SearchViewMainActivity;

public class MyBaseUIMainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_base_uimain);
        ((TextView) findViewById(R.id.tv_title)).setText("UI基本组件");

        findViewById(R.id.btn_button).setOnClickListener(this);
        findViewById(R.id.btn_searchView).setOnClickListener(this);
        findViewById(R.id.btn_dialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_button:
                startActivity(new Intent(MyBaseUIMainActivity.this, ButtonMainActivity.class));
                break;
            case R.id.btn_searchView:
                startActivity(new Intent(MyBaseUIMainActivity.this, SearchViewMainActivity.class));
                break;
            case R.id.btn_dialog:
                startActivity(new Intent(MyBaseUIMainActivity.this, DialogMainActivity.class));
                break;
            default:
                break;
        }
    }
}
