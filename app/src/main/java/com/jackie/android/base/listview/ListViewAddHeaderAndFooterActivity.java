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

public class ListViewAddHeaderAndFooterActivity extends Activity implements View.OnClickListener {

    private int mPage;
    private ListView list_view;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_add_header_and_footer);
        ((TextView) findViewById(R.id.tv_title)).setText("ListView添加头部和尾部");

        findViewById(R.id.btn_add_header).setOnClickListener(this);
        findViewById(R.id.btn_remove_header).setOnClickListener(this);
        findViewById(R.id.btn_add_footer).setOnClickListener(this);
        findViewById(R.id.btn_remove_footer).setOnClickListener(this);
        list_view = (ListView) findViewById(R.id.list_view);

        mPage = 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_header:
                addHeaderView();
                break;
            case R.id.btn_remove_header:
                removeHeaderView();
                break;
            case R.id.btn_add_footer:
                addFooterView();
                break;
            case R.id.btn_remove_footer:
                removeFooterView();
                break;
            default:
                break;
        }
    }

    private void removeFooterView() {
        list_view.removeFooterView(view);
    }

    private void addFooterView() {
        view = View.inflate(ListViewAddHeaderAndFooterActivity.this, R.layout.activity_list_view_base_use_item, null);
        list_view.addFooterView(view);
    }

    private void removeHeaderView() {
        list_view.removeHeaderView(view);
    }

    private void addHeaderView() {
        view = View.inflate(ListViewAddHeaderAndFooterActivity.this, R.layout.activity_list_view_base_use_item, null);
        list_view.addHeaderView(view);
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

        ListViewWrapperAdapter listViewWrapperAdapter = new ListViewWrapperAdapter(ListViewAddHeaderAndFooterActivity.this);
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
