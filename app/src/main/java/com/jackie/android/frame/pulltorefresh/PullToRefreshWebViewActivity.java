package com.jackie.android.frame.pulltorefresh;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import com.jackie.android.R;

public class PullToRefreshWebViewActivity extends Activity {

    private PullToRefreshWebView pull_refresh_webview;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_web_view);

        pull_refresh_webview = (PullToRefreshWebView) findViewById(R.id.pull_refresh_webview);

        webView = pull_refresh_webview.getRefreshableView();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://www.baidu.com");


        //也可以设置刷新监听
//        pull_refresh_webview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<WebView>() {
//            @Override
//            public void onRefresh(PullToRefreshBase<WebView> refreshView) {
//                //业务逻辑...
//            }
//        });
    }
}
