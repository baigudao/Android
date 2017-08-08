package com.jackie.android.frame.pulltorefresh;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.jackie.android.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PullToRefreshGridViewActivity extends Activity {

    private PullToRefreshGridView pull_refresh_grid;
    private GridView gridView;

    //数据
    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};

    private List<String> strings = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_grid_view);
        ((TextView) findViewById(R.id.tv_title)).setText("GridView");

        pull_refresh_grid = (PullToRefreshGridView) findViewById(R.id.pull_refresh_grid);

        pull_refresh_grid.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(PullToRefreshGridViewActivity.this, "下拉!", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(PullToRefreshGridViewActivity.this, "上拉!", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }
        });

        gridView = pull_refresh_grid.getRefreshableView();

        strings.addAll(Arrays.asList(mStrings));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);

    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            strings.add(0, "新增加的数据。。。");
            adapter.notifyDataSetChanged();

            pull_refresh_grid.onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
