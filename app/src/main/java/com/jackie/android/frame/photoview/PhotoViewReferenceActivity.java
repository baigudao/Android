package com.jackie.android.frame.photoview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jackie.android.R;

public class PhotoViewReferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view_reference);
        ((TextView) findViewById(R.id.tv_title)).setText("参考资料");
    }
}
