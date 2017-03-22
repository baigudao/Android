package com.jackie.android.frame;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.android.BaseFragment;
import com.jackie.android.R;
import com.jackie.android.frame.pulltorefresh.MyPullToRefreshMainActivity;
import com.jackie.android.frame.rongcloud.activity.MyRongCloudIMMainActivity;

/**
 * Created by jackie on 2017/3/12 15:33.
 * QQ : 971060378
 * Used as : xxx
 */

public class CommonFrameFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private CommonFrameFragmentAdapter adapter;
    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_common, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        //给listview的选项设置点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.equals("融云即时通讯")){
                    startActivity(new Intent(mContext,MyRongCloudIMMainActivity.class));
                }else if (data.toLowerCase().equals("pulltorefresh")){
                    startActivity(new Intent(mContext,MyPullToRefreshMainActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //准备数据
        datas = new String[]{"PullToRefresh","融云即时通讯",
                "....."};
        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
