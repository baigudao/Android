package com.jackie.android.base.webview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.android.R;

public class WebViewReferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_reference);
        ((TextView) findViewById(R.id.tv_title)).setText("参考资料");
    }
}
