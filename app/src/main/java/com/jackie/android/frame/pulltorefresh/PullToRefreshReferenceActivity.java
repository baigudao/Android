package com.jackie.android.frame.pulltorefresh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.android.R;

public class PullToRefreshReferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_reference);
        ((TextView)findViewById(R.id.tv_title)).setText("参考资料");
    }
}
