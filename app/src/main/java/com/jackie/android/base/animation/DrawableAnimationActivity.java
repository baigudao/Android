package com.jackie.android.base.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackie.android.R;

/**
 * 逐帧动画
 */
public class DrawableAnimationActivity extends Activity implements View.OnClickListener {

    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);

        ((TextView) findViewById(R.id.tv_title)).setText("逐帧动画");

        ImageView iv_test = (ImageView) findViewById(R.id.iv_test);
        // 获取AnimationDrawable动画对象
        anim = (AnimationDrawable) iv_test.getBackground();

        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                anim.start();
                break;
            case R.id.btn_finish:
                anim.stop();
                break;
            default:
                break;
        }
    }
}
