package com.jackie.android.base.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by jackie on 2017/3/28 23:00.
 * QQ : 971060378
 * Used as : xxx
 */

public class MyButton extends Button {

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("MyButton>>>","MyButton构造方法");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("MyButton>>>","dispatchTouchEvent  "+ event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("MyButton>>>","onTouchEvent  "+ event.getAction());
        return super.onTouchEvent(event);
    }


}
