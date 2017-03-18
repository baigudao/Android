package com.jackie.android.senior.view.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jackie on 2017/3/16 9:38.
 * QQ : 971060378
 * Used as : 创建，测量，布局，绘制，事件处理，死亡等等
 */
public class MyView extends View {

    private static final String TAG = MyView.class.getSimpleName();

    public MyView(Context context) {
        super(context);
        Log.e(TAG, "MyView(Context context)");
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, "MyView(Context context, AttributeSet attrs)");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw");
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Log.e(TAG, "onGenericMotionEvent");
        return super.onGenericMotionEvent(event);
    }

}
