package com.jackie.android.frame.pulltorefresh;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.jackie.android.R;

public class PullToRefreshScrollViewActivity extends Activity {

    private PullToRefreshScrollView pull_refresh_scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_torefresh_scroll_view);

        pull_refresh_scrollview = (PullToRefreshScrollView) findViewById(R.id.pull_refresh_scrollview);

        pull_refresh_scrollview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                new GetDataTask().execute();
            }
        });

    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {
            // Do some stuff here

            // Call onRefreshComplete when the list has been refreshed.
            pull_refresh_scrollview.onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
