package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_webview;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsInterface(), "jsBridge");

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(false);

        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件，若为false，则该webView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放空间

        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setDatabaseEnabled(true); //是否开启数据库缓存

        //WebViewClient 处理各种通知和请求事件
        webView.setWebViewClient(new WebViewClient(){
            //作用：WebView开始加载页面时回调，一次Frame加载对应一次回调
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("WebViewActivity","开始加载");
            }
            //作用：WebView完成加载页面时回调，一次Frame加载对应一次回调
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }
            //webView内置页面链接跳转都会走这个方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
            //加载页面资源时回调，每一个资源产生的一次网络加载，除非本地有当前url对应有缓存，否则就会加载
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            //WebVew可以拦截某一次的request来返回我们自己加载的数据，这个方法在后面缓存会有很大作用
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            //WebView ssl访问证书出错，handler.cancel()取消加载，handler.proceed()对错误也继续加载
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            //WebVew访问url出错
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });

        //WebChromeClient 处理JavaScript的对话框，网站图标，网站标题等
        webView.setWebChromeClient(new WebChromeClient(){

            //当前WebView加载网页进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("WebViewActivity","newProgress : "+newProgress);
                super.onProgressChanged(view, newProgress);
            }

            //输出Web端日志
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("WebViewActivity","consoleMessage : "+consoleMessage.message());
                return super.onConsoleMessage(consoleMessage);
            }

            //接受web页面的title
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.d("WebViewActivity","title : "+title);
            }

            //获取Web页面中的图标
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

            //获取Web页中，Js调用alert()函数，产生的对话框
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.d("WebViewActivity","onJsAlert : "+message);
                return super.onJsAlert(view, url, message, result);
            }
            //处理Js中的Prompt对话框
            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                Log.d("WebViewActivity","onJsPrompt : "+message);
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                Log.d("WebViewActivity","onJsConfirm : "+message);
                return super.onJsConfirm(view, url, message, result);
            }
        });

        webView.loadUrl("https://api.gilet.ceshi.in/testku.html");
    }
}
