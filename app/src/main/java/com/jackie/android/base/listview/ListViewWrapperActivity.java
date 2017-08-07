package com.jackie.android.base.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.android.R;

public class ListViewWrapperActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_wrapper);
        ((TextView) findViewById(R.id.tv_title)).setText("ListView的封装");
    }
}
