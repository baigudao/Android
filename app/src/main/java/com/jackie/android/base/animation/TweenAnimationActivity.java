package com.jackie.android.base.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackie.android.R;

/**
 * 补间动画
 */
public class TweenAnimationActivity extends Activity {

    private ImageView iv_animation;
    private TextView tv_animation_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ((TextView) findViewById(R.id.tv_title)).setText("补间动画");

        iv_animation = (ImageView) findViewById(R.id.iv_animation);
        tv_animation_msg = (TextView) findViewById(R.id.tv_animation_msg);
    }

    /**
     * 缩放动画
     *
     * @param view
     */
    public void startCodeScale(View view) {
        tv_animation_msg.setText("Code缩放动画: 宽度从0.5到1.5, 高度从0.0到1.0, 缩放的圆心为顶部中心点,延迟1s开始,持续2s,最终还原");
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.5f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
        scaleAnimation.setStartOffset(1000);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillBefore(true);
        iv_animation.setAnimation(scaleAnimation);
    }

    public void startXmlScale(View view) {
        tv_animation_msg.setText("Xml缩放动画: 宽度从0.0到1.5, 高度从0.0到1.0, 延迟1s开始,持续3s,圆心为右下角, 最终固定");
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.scale_test);
        iv_animation.setAnimation(scaleAnimation);
    }

    /**
     * 旋转动画
     *
     * @param view
     */
    public void startCodeRotate(View view) {
        tv_animation_msg.setText("Code旋转动画: 以图片中心点为中心, 从负90度到正90度, 持续5s");
        RotateAnimation rotateAnimation = new RotateAnimation(-90, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(5000);
        iv_animation.setAnimation(rotateAnimation);
    }

    public void startXmlRotate(View view) {
        tv_animation_msg.setText("Xml旋转动画: 以左顶点为坐标, 从正90度到负90度, 持续5s");
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate_test);
        iv_animation.setAnimation(rotateAnimation);
    }

    /**
     * 透明度动画
     *
     * @param view
     */
    public void startCodeAlpha(View view) {
        tv_animation_msg.setText("Code透明度动画: 从完全透明到完全不透明, 持续2s");
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        iv_animation.setAnimation(alphaAnimation);
    }

    public void startXmlAlpha(View view) {
        tv_animation_msg.setText("Xml透明度动画: 从完全不透明到完全透明, 持续4s");
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.alpha_test);
        iv_animation.setAnimation(alphaAnimation);
    }

    /**
     * 平移动画
     *
     * @param view
     */
    public void startCodeTranslate(View view) {
        tv_animation_msg.setText("Code移动动画: 向右移动一个自己的宽度, 向下移动一个自己的高度, 持续2s");
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1);
        translateAnimation.setDuration(2000);
        iv_animation.setAnimation(translateAnimation);
    }

    public void startXmlTranslate(View view) {
        tv_animation_msg.setText("xml移动动画: 从屏幕的右边逐渐回到原来的位置, 持续2s");
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.translate_test);
        iv_animation.setAnimation(translateAnimation);
    }

    /**
     * 复合动画
     *
     * @param view
     */
    public void startCodeAnimationSet(View view) {
        tv_animation_msg.setText("Code复合动画: 透明度从透明到不透明, 持续2s, 接着进行旋转360度的动画, 持续1s");
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setStartOffset(2000);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        iv_animation.setAnimation(animationSet);
    }

    public void startXmlAnimationSet(View view) {
        tv_animation_msg.setText("Xml复合动画: 透明度从透明到不透明, 持续2s, 接着进行旋转360度的动画, 持续2s");
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.set_test);
        iv_animation.setAnimation(animationSet);
    }

    /**
     * 测试动画监听
     *
     * @param v
     */
    public void testAnimationListener(View v) {
        tv_animation_msg.setText("测试动画监听");
        Animation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000);
        //设置线性变化
        animation.setInterpolator(new LinearInterpolator());
        //设置动画重复次数
        animation.setRepeatCount(Animation.INFINITE);
        //设置动画监听
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("TAG", "动画开始");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("TAG", "动画重复");

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("TAG", "动画结束");
            }
        });

        iv_animation.startAnimation(animation);
    }

    public void animationFinish(View view) {
        iv_animation.clearAnimation();
    }
}
