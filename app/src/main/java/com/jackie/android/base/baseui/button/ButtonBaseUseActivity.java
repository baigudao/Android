package com.jackie.android.base.baseui.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.android.R;

public class ButtonBaseUseActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_base_use);

        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("Button的基本使用");
        btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_test:
                Toast.makeText(this, "你点击了我啊！", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
