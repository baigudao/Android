package com.jackie.android.base;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.android.BaseFragment;
import com.jackie.android.R;
import com.jackie.android.base.webview.MyWebViewMainActivity;

/**
 * Created by jackie on 2017/3/12 15:30.
 * QQ : 971060378
 * Used as : Android基础页面
 */

public class BaseAndroidFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private BaseAndroidFragmentAdapter adapter;
    private static final String TAG = BaseAndroidFragment.class.getSimpleName();//"BaseAndroidFragment"

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_common, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        //给listview的选项设置点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.toLowerCase().equals("webview")){
                    startActivity(new Intent(mContext,MyWebViewMainActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //准备数据
        datas = new String[]{"WebView",
                "....."};
        //设置适配器
        adapter = new BaseAndroidFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
