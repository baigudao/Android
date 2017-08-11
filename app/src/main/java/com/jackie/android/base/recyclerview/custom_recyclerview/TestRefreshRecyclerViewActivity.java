package com.jackie.android.base.recyclerview.custom_recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.jackie.android.R;
import com.jackie.android.bean.FuLiImageBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * Created by jackie on 2017/8/11 15:14.
 * QQ : 971060378
 * Used as : xxx
 */
public class TestRefreshRecyclerViewActivity extends Activity {

    private static final int REFRESH = 0;
    private static final int LOADMORE = 1;
    private RefreshRecyclerView recycler_view;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH:
                    recycler_view.onFinishRefresh(true);
                    break;
                case LOADMORE:
                    recycler_view.onFinishRefresh(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_refresh_recycler_view);

        recycler_view = (RefreshRecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .url("http://gank.io/api/data/福利/10/1")
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


        TestRecyclerViewAdapter testRecyclerViewAdapter = new TestRecyclerViewAdapter(this, fuLiImageBean.getResults());
        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(testRecyclerViewAdapter);
        //        不要忘记设置布局管理器
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler_view.setAdapter(headerAndFooterWrapper);
        recycler_view.addHeaderView(recycler_view.getHeaderView(), headerAndFooterWrapper);
        recycler_view.addFooterView(recycler_view.getFooterView(), headerAndFooterWrapper);
        recycler_view.setOnRefreshListener(new RefreshRecyclerView.OnRefreshListener() {
            @Override
            public void onPullDownRefresh() {
                //           执行下拉刷新操作，一般是联网更新数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        handler.sendEmptyMessage(REFRESH);
                    }
                }).start();
            }

            @Override
            public void onLoadingMore() {
                //            执行上拉加载操作，一般是联网请求更多分页数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        handler.sendEmptyMessage(LOADMORE);
                    }
                }).start();
            }
        });
    }
}
