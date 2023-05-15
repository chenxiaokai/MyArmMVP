package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JsInterface {

    @JavascriptInterface
    public void postMessage(String type, String json) {
        switch (type) {
            case "login":
                //登录成功

                break;
            case "logout":
                //退出成功

                break;
            case "register":
                //注册成功

                break;
            case "registerClick":
                //点击注册成功

                break;
            case "rechargeClick":
                //点击存款成功

                break;
            case "firstrecharge":
                //首充成功(需要传金额)

                break;
            case "recharge":
                //复充成功(需要传金额)

                break;
            case "withdrawClick":
                //点击取款成功

                break;
            case "withdrawOrderSuccess":
                //取款成功(需要传金额)

                break;
        }
    }
}
