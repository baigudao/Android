package com.jackie.android.senior;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.android.BaseFragment;
import com.jackie.android.R;
import com.jackie.android.senior.view.activity.MyViewMainActivity;

/**
 * Created by jackie on 2017/3/12 15:31.
 * QQ : 971060378
 * Used as : xxx
 */

public class SeniorAndroidFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private SeniorAndroidFragmentAdapter adapter;
    private static final String TAG = SeniorAndroidFragment.class.getSimpleName();//"SeniorAndroidFragment"

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_common, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        //给listview的选项设置点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.toLowerCase().equals("view")){
                    startActivity(new Intent(mContext,MyViewMainActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //准备数据
        datas = new String[]{"View",
                "....."};
        //设置适配器
        adapter = new SeniorAndroidFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
