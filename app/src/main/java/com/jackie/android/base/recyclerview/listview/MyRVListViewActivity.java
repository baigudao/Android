package com.jackie.android.base.recyclerview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jackie.android.R;
import com.jackie.android.base.recyclerview.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView总结:
 * 1，可以实现ListView，GridView，瀑布流的效果
 * 2，一定要设置布局管理器
 * 3，设置分割线
 * 4，设置item的点击和长按事件
 * 5，添加和移除数据
 * 6，设置添加和移除动画
 */
public class MyRVListViewActivity extends Activity implements View.OnClickListener {

    private RecyclerView recycler_view;
    private List<String> strings = new ArrayList<>();
    private MyRVListViewAdapter adapter;

    private Button btn_add;
    private Button btn_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rvlist_view);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_remove = (Button) findViewById(R.id.btn_remove);

        //准备数据
        initData();
        //定义adapter
        adapter = new MyRVListViewAdapter(this, strings);
        //设置适配器
        recycler_view.setAdapter(adapter);
        //设置布局管理器
        /**
         * 1，上下文
         * 2，布局方向
         * 3，是否倒序排列
         */
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //添加分割线
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //设置点击事件
        adapter.setOnItemClickListener(new MyRVListViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MyRVListViewActivity.this, "点击事件" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MyRVListViewActivity.this, "长按事件" + position, Toast.LENGTH_SHORT).show();
            }
        });

        btn_add.setOnClickListener(this);
        btn_remove.setOnClickListener(this);

        //设置Item增加、移除动画
        recycler_view.setItemAnimator(new DefaultItemAnimator());

    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            strings.add("我厉害吧！ " + i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                strings.add(0, "新增的数据");
                adapter.notifyItemInserted(0);
                //设置回滚到新增的item项
                recycler_view.scrollToPosition(0);
                break;
            case R.id.btn_remove:
                adapter.notifyItemRemoved(0);
                break;
            default:
                break;
        }
    }
}
