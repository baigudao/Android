package com.jackie.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.jackie.android.utils.CacheUtils;

public class SplashActivity extends Activity {

    public static final String START_MAIN = "start_main";
    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rl_splash_root = (RelativeLayout) findViewById(R.id.rl_splash_root);

        //渐变动画
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        //        aa.setDuration(500);//持续播放时间
        aa.setFillAfter(true);
        //缩放动画
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        //        sa.setDuration(500);
        sa.setFillAfter(true);
        //旋转动画
        //        RotateAnimation ra = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        //        ra.setDuration(500);
        //        ra.setFillAfter(true);

        //设置动画集
        AnimationSet set = new AnimationSet(false);
        //添加三个动画没有先后顺序,便于同时播放动画
        //        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.setDuration(2000);

        //开始播放动画
        rl_splash_root.startAnimation(set);

        //给动画集设置动画监听
        set.setAnimationListener(new MyAnimationListener());
    }

    class MyAnimationListener implements Animation.AnimationListener {
        /**
         * 当动画开始播放的时候回调这个方法
         *
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {
        }

        /**
         * 当动画播放结束的时候回调这个方法
         *
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            //判断是否进入过主页面
            boolean isStartMain = CacheUtils.getBoolean(SplashActivity.this, START_MAIN);
            Intent intent;
            if (isStartMain) {
                //如果进入过主页面，直接进入主页面
                intent = new Intent(SplashActivity.this, MainActivity.class);
            } else {
                //如果没有进入过主页面，进入引导页面
                intent = new Intent(SplashActivity.this, GuideActivity.class);
            }
            startActivity(intent);
            //关闭Splash页面
            finish();
        }

        /**
         * 当动画重复播放的时候回调这个方法
         *
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
