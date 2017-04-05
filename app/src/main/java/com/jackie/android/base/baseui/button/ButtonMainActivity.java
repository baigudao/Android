package com.jackie.android.base.baseui.button;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.android.R;

public class ButtonMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_register_login;
    private Button btn_base_use;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_main);

        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("Button");
        btn_base_use = (Button)findViewById(R.id.btn_base_use);
        btn_register_login = (Button)findViewById(R.id.btn_register_login);
        btn_base_use.setOnClickListener(this);
        btn_register_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_base_use:
                startActivity(new Intent(ButtonMainActivity.this,ButtonBaseUseActivity.class));
                break;
            case R.id.btn_register_login:
                startActivity(new Intent(ButtonMainActivity.this,ButtonRegisterAndLoginActivity.class));
                Toast.makeText(this, "注册和登录", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
