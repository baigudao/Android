package com.jackie.android.frame.jsonparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.android.R;

public class MyJSONParseMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_json_parse_native;
    private Button btn_json_parse_gson;
    private Button btn_json_parse_fastjson;
    private Button btn_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_json_parse_native.setOnClickListener(this);
        btn_json_parse_gson.setOnClickListener(this);
        btn_json_parse_fastjson.setOnClickListener(this);
        btn_reference.setOnClickListener(this);
    }

    private void initData() {
        tv_title.setText("JSON解析");
    }

    private void initView() {
        setContentView(R.layout.activity_my_jsonparse_main);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_json_parse_native = (Button) findViewById(R.id.btn_json_parse_native);
        btn_json_parse_gson = (Button) findViewById(R.id.btn_json_parse_gson);
        btn_json_parse_fastjson = (Button) findViewById(R.id.btn_json_parse_fastjson);
        btn_reference = (Button)findViewById(R.id.btn_reference);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_json_parse_native:
                startActivity(new Intent(this,JSONParseByNativeActivity.class));
                break;
            case R.id.btn_json_parse_gson:
                startActivity(new Intent(this,JSONParseByGSONActivity.class));
                break;
            case R.id.btn_json_parse_fastjson:
                startActivity(new Intent(this,JSONParseByFastJsonActivity.class));
                break;
            case R.id.btn_reference:
                Toast.makeText(this, "reference", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
