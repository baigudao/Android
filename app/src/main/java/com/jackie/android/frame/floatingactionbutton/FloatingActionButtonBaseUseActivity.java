package com.jackie.android.frame.floatingactionbutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.android.R;

public class FloatingActionButtonBaseUseActivity extends Activity {

    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button_base_use);

        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("基本使用");
    }
}
