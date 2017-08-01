package com.jackie.android.base.recyclerview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jackie.android.R;
import com.jackie.android.base.recyclerview.utils.DividerItemDecoration;
import com.jackie.android.bean.FuLiImageBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * RecyclerView总结:
 * 1，可以实现ListView，GridView，瀑布流的效果
 * 2，一定要设置布局管理器
 * 3，设置分割线
 * 4，设置item的点击和长按事件
 * 5，添加和移除数据
 * 6，设置添加和移除动画
 */
public class MyRVListViewActivity extends Activity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recycler_view;
    private MyRVListViewAdapter adapter;

    private Button btn_add;
    private Button btn_remove;
    private int mPage;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rvlist_view);
        ((TextView) findViewById(R.id.tv_title)).setText("ListView的效果");

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.grid_swipe_refresh);
        //调整SwipeRefreshLayout的位置
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
        //设置SwipeRefreshLayout的刷新监听器
        swipeRefreshLayout.setOnRefreshListener(this);


        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        //设置布局管理器
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        /**
         * 1，上下文
         * 2，布局方向
         * 3，是否倒序排列
         */
        recycler_view.setLayoutManager(mLayoutManager);

        //添加分割线
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //设置Item增加、移除动画
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        //设置加载更多
        recycler_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取加载的最后一个可见视图在适配器的位置。
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 2 >= mLayoutManager.getItemCount()) {
                    ++mPage;
                    getDataFromNet();
                }
            }
        });
//        btn_add = (Button) findViewById(R.id.btn_add);
//        btn_remove = (Button) findViewById(R.id.btn_remove);
//        btn_add.setOnClickListener(this);
//        btn_remove.setOnClickListener(this);

        mPage = 1;
    }

    @Override
    protected void onStart() {
        super.onStart();
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .url("http://gank.io/api/data/福利/10/" + mPage)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            handleImageData(jsonObject);
                            swipeRefreshLayout.setRefreshing(false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void handleImageData(JSONObject jsonObject) {
        Gson gson = new Gson();
        //准备数据
        FuLiImageBean fuLiImageBean = gson.fromJson(jsonObject.toString(), FuLiImageBean.class);

        //定义adapter
        adapter = new MyRVListViewAdapter(this, fuLiImageBean.getResults());
        //设置适配器
        recycler_view.setAdapter(adapter);

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btn_add:
//                strings.add(0, "新增的数据");
//                adapter.notifyItemInserted(0);
//                //设置回滚到新增的item项
//                recycler_view.scrollToPosition(0);
//                break;
//            case R.id.btn_remove:
//                adapter.notifyItemRemoved(0);
//                break;
            default:
                break;
        }
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        mPage = 1;
        getDataFromNet();
    }
}
