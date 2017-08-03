package com.jackie.android.base.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jackie.android.R;
import com.jackie.android.base.animation.view_animation.TweenAnimationActivity;

/**
 * Created by jackie on 2017/5/28 0:14.
 * QQ : 971060378
 * Used as : 动画页面
 */

public class MyAnimationMainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_animation_main);
        ((TextView) findViewById(R.id.tv_title)).setText("动画");

        findViewById(R.id.btn_tween).setOnClickListener(this);
//        findViewById(R.id.btn_rotate).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween:
                startActivity(new Intent(MyAnimationMainActivity.this, TweenAnimationActivity.class));
                break;
//            case R.id.btn_rotate:
//                startActivity(new Intent(MyAnimationMainActivity.this,RotateAnimationActivity.class));
//                break;
            default:
                break;
        }
    }
}
