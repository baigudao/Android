package com.jackie.android.senior.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.android.R;

/**
 * Created by jackie on 2017/3/15 22:42.
 * QQ : 971060378
 * Used as : View的主页面
 */

public class MyViewMainActivity extends Activity {

    private Button btn_test;
    private TextView tv_test;

    private MyView mv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_main);

        btn_test = (Button)findViewById(R.id.btn_test);
        tv_test = (TextView)findViewById(R.id.tv_test);

        mv_test = (MyView)findViewById(R.id.mv_test);


        final int i = ViewConfiguration.get(this).getScaledDoubleTapSlop();//系统能识别的最小滑动距离

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyViewMainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });


        mv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyViewMainActivity.this, "哈哈!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
