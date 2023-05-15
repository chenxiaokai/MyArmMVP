package me.jessyan.mvparms.demo.utils;

import android.content.Context;

import com.appsflyer.AppsFlyerLib;

public class AFUtils {

    //https://dev.appsflyer.com/hc/docs/in-app-events-android
    public static void init(Context context) {
        AppsFlyerLib.getInstance().init("", null, context);
        AppsFlyerLib.getInstance().start(context);
    }

    public static void logEvent(Context context, String msg, String content) {

    }
}
