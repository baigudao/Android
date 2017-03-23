package com.jackie.android.frame.pulltorefresh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jackie.android.R;

public class MyPullToRefreshMainActivity extends Activity implements View.OnClickListener {

    private Button btn_list_view;
    private Button btn_grid_view;
    private Button btn_web_view;
    private Button btn_scroll_view;
    private Button btn_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pull_to_refresh_main);

        btn_list_view = (Button) findViewById(R.id.btn_list_view);
        btn_grid_view = (Button) findViewById(R.id.btn_grid_view);
        btn_web_view = (Button) findViewById(R.id.btn_web_view);
        btn_scroll_view = (Button) findViewById(R.id.btn_scroll_view);
        btn_reference = (Button) findViewById(R.id.btn_reference);

        btn_list_view.setOnClickListener(this);
        btn_grid_view.setOnClickListener(this);
        btn_web_view.setOnClickListener(this);
        btn_scroll_view.setOnClickListener(this);
        btn_reference.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_list_view:
                startActivity(new Intent(this, PullToRefreshListViewActivity.class));
                break;
            case R.id.btn_grid_view:
                startActivity(new Intent(this, PullToRefreshGridViewActivity.class));
                break;
            case R.id.btn_web_view:
                startActivity(new Intent(this, PullToRefreshWebViewActivity.class));
                break;
            case R.id.btn_scroll_view:
                startActivity(new Intent(this, PullToRefreshScrollViewActivity.class));//startActivity(new Intent(this,RecyclerViewReferenceActivity.class));
                break;
            case R.id.btn_reference:
                startActivity(new Intent(this, PullToRefreshReferenceActivity.class));
                break;
            default:
                break;
        }
    }
}
