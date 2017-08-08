package com.jackie.android.frame.glide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.android.R;

public class GlideReferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_reference);

        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("参考资料");
    }
}
