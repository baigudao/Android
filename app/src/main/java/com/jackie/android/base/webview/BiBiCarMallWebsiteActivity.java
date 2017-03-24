package com.jackie.android.base.webview;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jackie.android.R;

public class BiBiCarMallWebsiteActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bi_bi_car_mall_website);

        webView = (WebView) findViewById(R.id.webview);

        //加载bibicar商城网页
        LoadBiBiCarMallWebsite();
    }

    private void LoadBiBiCarMallWebsite() {
        //        String url = "http://wap.bibicar.cn/shop";//网页地址
        String url = "http://www.baidu.com";
        if (!TextUtils.isEmpty(url)) {
            WebSettings webSettings = webView.getSettings();

            webSettings.setJavaScriptEnabled(true);//Tells the WebView to enable JavaScript execution. The my_default is false.

            if (Build.VERSION.SDK_INT < 19) {
                if (Build.VERSION.SDK_INT > 8) {
                    webSettings.setPluginState(WebSettings.PluginState.ON);//Tells the WebView to enable, disable, or have plugins on demand.The my_default is OFF.
                }
            }

            webSettings.setSupportZoom(true);//Sets whether the WebView should support zooming using its on-screen zoom controls and gestures.The my_default is true.
            webSettings.setLoadWithOverviewMode(true);//Sets whether the WebView loads pages in overview mode, that is, zooms out the content to fit on screen by width.The my_default is false.
            webSettings.setDomStorageEnabled(true);//Sets whether the DOM storage API is enabled. The my_default value is false.
            webSettings.setUseWideViewPort(true);//Sets whether the WebView should enable support for the "viewport" HTML meta tag or should use a wide viewport.

            webSettings.setAllowContentAccess(true);//Enables or disables content URL access within WebView.The my_default is enabled.
            webSettings.setAllowFileAccess(true);//Enables or disables file access within WebView. File access is enabled by my_default.

            webSettings.setAppCacheMaxSize(1024 * 1024 * 8);
            String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
            webSettings.setAppCachePath(appCachePath);
            webSettings.setAppCacheEnabled(true);//Sets whether the Application Caches API should be enabled. The my_default is false.Note that in order for the Application Caches API to be enabled, a valid database path must also be supplied to setAppCachePath(String).

            //            webSettings.setAllowFileAccessFromFileURLs(false);//参见官方API
            //            webSettings.setAllowUniversalAccessFromFileURLs(false)//参见官方API

            /**
             * WebViewClient与WebChromeClient的区别
             *WebViewClient:在影响View的事件到来时，会通过WebViewClient中的方法回调通知用户
             *WebChromeClient：当影响浏览器的事件到来时，就会通过WebChromeClient中的方法回调通知用法。
             */
            webView.setWebViewClient(new MyWebViewClient(this));//要在WebView中打开链接，就必须要设置WebViewClient;

            webView.setWebChromeClient(new MyWebChromeClient());//实现网页中对话框的弹出都要设置MyWebChromeClient

            webView.loadUrl("file:///android_asset/test.html");//加载在线URL

        }
    }
}
