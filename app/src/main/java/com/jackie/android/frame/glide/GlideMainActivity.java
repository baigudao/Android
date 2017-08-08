package com.jackie.android.frame.glide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jackie.android.R;

public class GlideMainActivity extends Activity implements View.OnClickListener{

    private TextView tv_title;
    private Button btn_glide_base;
    private Button btn_glide_recyclerView;
    private Button btn_glide_transformation;
    private Button btn_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_main);

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("Glide的使用");

        btn_glide_base = (Button)findViewById(R.id.btn_glide_base);
        btn_glide_recyclerView = (Button)findViewById(R.id.btn_glide_recyclerView);
        btn_glide_transformation = (Button)findViewById(R.id.btn_glide_transformation);
        btn_reference = (Button)findViewById(R.id.btn_reference);

        btn_glide_base.setOnClickListener(this);
        btn_glide_recyclerView.setOnClickListener(this);
        btn_glide_transformation.setOnClickListener(this);
        btn_reference.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_glide_base:
                startActivity(new Intent(this, GlideBaseUseActivity.class));
                break;
            case R.id.btn_glide_recyclerView:
                startActivity(new Intent(this,GlideRecyclerViewActivity.class));
                break;
            case R.id.btn_glide_transformation:
                startActivity(new Intent(this,GlideTransformationActivity.class));
                break;
            case R.id.btn_reference:
                startActivity(new Intent(this,GlideReferenceActivity.class));
            default:
                break;
        }
    }
}
