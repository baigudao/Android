package com.jackie.android.frame.pulltorefresh;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;
import com.jackie.android.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PullToRefresh基本用法：
 * 1、在布局文件中添加PullToRefresh控件，比如PullToRefreshListView；
 * 2、在Activity中，设置监听器OnRefreshListener以响应用户下拉操作；
 * 3、在监听器的onRefresh()方法中执行数据刷新操作，可以通过AsyncTask来实现；
 * 4、在AsyncTask中获取到数据后，记得调用onRefreshComplete()方法通知PullToRefresh控件数据已获取完毕，可以结束刷新操作。
 */
public class PullToRefreshListViewActivity extends Activity {

    private PullToRefreshListView pull_refresh_list;

    //数据
    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};

    //数据集合
    private List<String> strings = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_list_view);

        pull_refresh_list = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);

        //设置刷新监听
        pull_refresh_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                ////得到当前刷新时间
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // 设置时间
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                // 业务逻辑的处理
                new GetDataTask().execute();
            }
        });

        //        //设置刷新监听，也可以用这个。
        //        pull_refresh_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
        //
        //            //下拉刷新
        //            @Override
        //            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        //            }
        //
        //            //上拉刷新
        //            @Override
        //            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        //            }
        //        });


        //设置最后一条监听
        pull_refresh_list.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                Toast.makeText(PullToRefreshListViewActivity.this, "已经到底了，不要再扯了！", Toast.LENGTH_SHORT).show();
            }
        });

        //设置刷新声音监听
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener<>(this);
        soundListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH, R.raw.pull_event);
        soundListener.addSoundEvent(PullToRefreshBase.State.RESET, R.raw.reset_sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.refreshing_sound);
        pull_refresh_list.setOnPullEventListener(soundListener);


        //得到真实的ListView
        ListView actualListView = pull_refresh_list.getRefreshableView();
        //准备数据
        strings.addAll(Arrays.asList(mStrings));
        //定义适配器
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        //设置适配器
        actualListView.setAdapter(adapter);
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
            strings.add(0, "新的数据。。。");
            adapter.notifyDataSetChanged();

            // 使PullToRefresh恢复初始化状态
            pull_refresh_list.onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
