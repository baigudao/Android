package com.jackie.android.base;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.android.BaseFragment;
import com.jackie.android.R;
import com.jackie.android.base.baseui.MyBaseUIMainActivity;
import com.jackie.android.base.event.MyEventMainActivity;
import com.jackie.android.base.listview.MyListViewMainActivity;
import com.jackie.android.base.recyclerview.MyRecyclerViewMainActivity;
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
                }else if (data.toLowerCase().equals("listview")){
                    startActivity(new Intent(mContext, MyListViewMainActivity.class));
                }else if (data.toLowerCase().equals("recyclerview")){
                    startActivity(new Intent(mContext, MyRecyclerViewMainActivity.class));
                }else if (data.equals("UI基础组件")){
                    startActivity(new Intent(mContext,MyBaseUIMainActivity.class));
                }else if (data.equals("事件处理机制")){
                    startActivity(new Intent(mContext,MyEventMainActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //准备数据
        datas = new String[]{"UI基础组件","ListView","RecyclerView","WebView","事件处理机制",
                "....."};
        //设置适配器
        adapter = new BaseAndroidFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
