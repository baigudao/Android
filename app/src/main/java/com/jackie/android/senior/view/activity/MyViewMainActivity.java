package com.jackie.android.senior.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jackie.android.R;

/**
 * Created by jackie on 2017/3/15 22:42.
 * QQ : 971060378
 * Used as : View的主页面
 */

public class MyViewMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_main);

        View view = new View(this);
        view.getX();
    }
}
