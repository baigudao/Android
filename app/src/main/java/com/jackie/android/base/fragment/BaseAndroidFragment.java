package com.jackie.android.base.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.jackie.android.BaseFragment;

/**
 * Created by jackie on 2017/3/12 15:30.
 * QQ : 971060378
 * Used as : xxx
 */

public class BaseAndroidFragment extends BaseFragment {

    private TextView textView;

    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("基本android");
    }
}
