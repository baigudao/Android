package com.jackie.android.base.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.android.R;

public class EventMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_motion_event;
    private Button btn_key_event;
    private Button btn_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_main);

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("事件处理");
        btn_motion_event = (Button) findViewById(R.id.btn_motion_event);
        btn_key_event = (Button) findViewById(R.id.btn_key_event);
        btn_reference = (Button)findViewById(R.id.btn_reference);

        btn_motion_event.setOnClickListener(this);
        btn_key_event.setOnClickListener(this);
        btn_reference.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_motion_event:
                startActivity(new Intent(this,MotionEventActivity.class));
                break;
            case R.id.btn_key_event:
                Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_reference:
                startActivity(new Intent(this,EventReferenceActivity.class));
                break;
            default:
                break;
        }
    }
}
