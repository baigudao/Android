package com.jackie.android.other.utiltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jackie.android.R;

public class MyUtilTestMainActivity extends Activity {

    private ListView listView;
    private String[] datas;
    private MyUtilTestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util_test_main);
        ((TextView)findViewById(R.id.tv_title)).setText("Android常用工具类测试");
        listView = (ListView)findViewById(R.id.listview);
        initData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = datas [i];
                if (data.equals("高斯模糊")){
                    startActivity(new Intent(MyUtilTestMainActivity.this,ImageFilterTestActivity.class));
                }
            }
        });
    }

    private void initData() {
        //准备数据
        datas = new String[]{"高斯模糊",
                "....."};
        //设置适配器
        adapter = new MyUtilTestAdapter(this, datas);
        listView.setAdapter(adapter);
    }
}
