package com.jackie.android.base.baseui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.android.R;
import com.jackie.android.base.baseui.button.ButtonMainActivity;

public class MyBaseUIMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_base_uimain);

        btn_button = (Button)findViewById(R.id.btn_button);
        btn_button.setOnClickListener(this);
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("UI基本组件");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_button:
                startActivity(new Intent(MyBaseUIMainActivity.this,ButtonMainActivity.class));
                break;
            default:
                break;
        }
    }
}
