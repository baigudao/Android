package com.jackie.android.base.baseui.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jackie.android.R;

public class DialogMainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);
        ((TextView) findViewById(R.id.tv_title)).setText("对话框");

        findViewById(R.id.btn_popupWindow).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_popupWindow:
                startActivity(new Intent(DialogMainActivity.this,PopupWindowActivity.class));
                break;
            default:
                break;
        }
    }
}
