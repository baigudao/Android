package com.jackie.android.base.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.android.R;

public class MotionEventActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);

        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("MotionEvent");
        btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
        btn_test.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("MyButton>>>","onTouch监听  "+ motionEvent.getAction());
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_test:
                Toast.makeText(this, "哈哈", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    /**
     * Activity的事件分发
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("MotionEventActivity===","dispatchTouchEvent  "+ ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Activity的触摸事件回调
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("MotionEventActivity===","onTouchEvent  "+ event.getAction());
        return super.onTouchEvent(event);
    }
}
