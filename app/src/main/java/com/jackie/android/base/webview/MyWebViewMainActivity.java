package com.jackie.android.base.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jackie.android.R;

public class MyWebViewMainActivity extends Activity implements View.OnClickListener {


    private Button btn_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view_main);

        btn_load = (Button) findViewById(R.id.btn_load);

        btn_load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load:
                startActivity(new Intent(this,BiBiCarMallWebsiteActivity.class));
                break;
            default:
                break;
        }
    }
}
