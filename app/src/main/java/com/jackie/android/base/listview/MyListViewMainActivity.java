package com.jackie.android.base.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.jackie.android.R;

import java.util.ArrayList;
import java.util.List;

public class MyListViewMainActivity extends Activity {

    private ListView list_view;
    private List<String> strings = new ArrayList<>();//新建一个空的集合，用来存放String对象
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_main);

        list_view = (ListView)findViewById(R.id.list_view);

        //始终是这三步：1，准备数据；2，定义适配器，3，设置适配器
        //准备数据
        strings.add("孙悟空");
        strings.add("唐僧");
        strings.add("沙和尚");
        strings.add("猪八戒");
        //定义适配器
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,strings);
        //设置适配器
        list_view.setAdapter(adapter);

        ImageView imageView = new ImageView(this);
        imageView.setBackground(getResources().getDrawable(R.drawable.other_follow));
        list_view.addFooterView(imageView);

    }
}
