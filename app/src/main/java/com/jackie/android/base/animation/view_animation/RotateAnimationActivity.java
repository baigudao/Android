package com.jackie.android.base.animation.view_animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.jackie.android.R;

public class RotateAnimationActivity extends AppCompatActivity {

    private ImageView iv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_animation);

        iv_test = (ImageView) findViewById(R.id.iv_test);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateImage();
                findViewById(R.id.btn_start).setVisibility(View.GONE);
            }
        });
    }

    private void rotateImage() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        iv_test.setAnimation(rotateAnimation);
    }
}
