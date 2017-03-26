package com.jackie.android.frame.floatingactionbutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.android.R;

public class MyFloatingActionButtonMainActivity extends Activity implements View.OnClickListener{

    private Button btn_base_use;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_floating_action_button_main);

        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("android-floating-action_button");
        btn_base_use = (Button)findViewById(R.id.btn_base_use);
        btn_base_use.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_base_use:
                startActivity(new Intent(this,FloatingActionButtonBaseUseActivity.class));
                break;
            default:
                break;
        }
    }
}
