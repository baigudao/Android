package com.jackie.android.base.webview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by jackie on 2017/3/19 22:31.
 * QQ : 971060378
 * Used as :
 * Sets the WebViewClient that will receive various notifications and requests. This will replace the current handler.
 * Sets the chrome handler. This is an implementation of WebChromeClient for use in handling JavaScript dialogs, favicons, titles, and the progress. This will replace the current handler.
 */

public class MyWebViewClient extends WebViewClient {

    private static final String TAG = MyWebViewClient.class.getSimpleName();

    private ProgressDialog mProgressDialog;

    public MyWebViewClient(Context context) {
        super();
        Log.e("调用构造器===", "MyWebViewClient()");
        mProgressDialog = new ProgressDialog(context);
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
        Log.e(TAG, "onReceivedLoginRequest(WebView view, String realm, String account, String args) ");
    }

    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
        Log.e(TAG, "onScaleChanged(WebView view, float oldScale, float newScale) ");
    }

    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        super.onUnhandledKeyEvent(view, event);
        Log.e(TAG, "onUnhandledKeyEvent(WebView view, KeyEvent event) ");
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        Log.e(TAG, "shouldOverrideKeyEvent(WebView view, KeyEvent event) ");
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        Log.e(TAG, "onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) ");
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        Log.e(TAG, "onReceivedClientCertRequest(WebView view, ClientCertRequest request) ");
        super.onReceivedClientCertRequest(view, request);
    }

    /**
     * 当接收到https错误时，会回调此函数，在其中可以做错误处理
     */
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        Log.e(TAG, "onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) ");
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
        Log.e(TAG, "doUpdateVisitedHistory(WebView view, String url, boolean isReload)");
    }

    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        super.onFormResubmission(view, dontResend, resend);
        Log.e(TAG, "onFormResubmission(WebView view, Message dontResend, Message resend) ");
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        Log.e(TAG, "onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) ");
    }

    /**
     * 加载错误的时候会回调，在其中可做错误处理，比如再请求加载一次，或者提示404的错误页面
     */
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        Log.e(TAG, "onReceivedError(WebView view, WebResourceRequest request, WebResourceError error)  ");
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        Log.e(TAG, "onReceivedError(WebView view, int errorCode, String description, String failingUrl) ");
    }

    /**
     * 拦截 url 跳转,在里边添加点击链接跳转或者操作
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.e(TAG, "shouldOverrideUrlLoading(WebView view, String url)  ");
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Log.e(TAG, "shouldOverrideUrlLoading(WebView view, WebResourceRequest request) ");
        return super.shouldOverrideUrlLoading(view, request);
    }

    /**
     * 在开始加载网页时会回调
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.e(TAG, "onPageStarted(WebView view, String url, Bitmap favicon) ");
        mProgressDialog.show();
    }

    /**
     * 在结束加载网页时会回调
     */
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        Log.e(TAG, "onPageFinished(WebView view, String url) ");
        mProgressDialog.hide();
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        Log.e(TAG, "onLoadResource(WebView view, String url)");
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
        Log.e(TAG, "onPageCommitVisible(WebView view, String url)");
    }

    /**
     * 在每一次请求资源时，都会通过这个函数来回调
     */
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Log.e(TAG, "shouldInterceptRequest(WebView view, String url)");
        return super.shouldInterceptRequest(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Log.e(TAG, "shouldInterceptRequest(WebView view, WebResourceRequest request)");
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
        Log.e(TAG, "onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg)");
        super.onTooManyRedirects(view, cancelMsg, continueMsg);
    }
}
