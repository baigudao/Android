package com.jackie.android.other;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by jackie on 2017/3/30 21:40.
 * QQ : 971060378
 * Used as : xxx
 */

public class OtherFragmentAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] mDatas;

    public OtherFragmentAdapter(Context context, String[] datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.length;
    }

    @Override
    public Object getItem(int position) {
        return mDatas [position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setPadding(15, 15, 0, 15);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(18);
        textView.setText(mDatas[position]);
        return textView;
    }
}
