package com.jackie.android.base.animation.view_animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.jackie.android.R;

public class ScaleAnimationActivity extends AppCompatActivity {

    private ImageView iv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_animation);

        iv_test = (ImageView) findViewById(R.id.iv_test);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleImage();
            }
        });
    }

    private void scaleImage() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(5000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setStartOffset(3000);
        scaleAnimation.setRepeatCount(3);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(ScaleAnimationActivity.this, "缩放开始了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(ScaleAnimationActivity.this, "缩放结束了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv_test.startAnimation(scaleAnimation);
    }
}
