package com.jackie.android.other;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jackie.android.BaseFragment;
import com.jackie.android.R;
import com.jackie.android.other.utiltest.MyUtilTestMainActivity;

/**
 * Created by jackie on 2017/3/12 15:34.
 * QQ : 971060378
 * Used as : 其他Fragment
 */

public class OtherFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;
    private OtherFragmentAdapter adapter;
    private static final String TAG = OtherFragment.class.getSimpleName();//"OtherFragment"

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_common, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        //给listview的选项设置点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                if (data.equals("Android常用工具类测试")) {
                    startActivity(new Intent(mContext, MyUtilTestMainActivity.class));
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //准备数据
        datas = new String[]{"Android常用工具类测试",
                "....."};
        //设置适配器
        adapter = new OtherFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
