package com.jackie.android.base.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.jackie.android.R;
import com.jackie.android.bean.FuLiImageBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;

public class ListViewWrapperActivity extends Activity {

    private int mPage;
    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_wrapper);
        ((TextView) findViewById(R.id.tv_title)).setText("ListView的封装");

        list_view = (ListView) findViewById(R.id.list_view);

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

        ListViewWrapperAdapter listViewWrapperAdapter = new ListViewWrapperAdapter(ListViewWrapperActivity.this);
        listViewWrapperAdapter.setDataList((ArrayList<FuLiImageBean.ResultsBean>) fuLiImageBean.getResults());
        list_view.setAdapter(listViewWrapperAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtils.showShort("点击了第" + i + "个");
            }
        });
    }
}
