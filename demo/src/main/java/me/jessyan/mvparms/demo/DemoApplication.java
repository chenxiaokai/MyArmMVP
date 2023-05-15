package me.jessyan.mvparms.demo;

import com.jess.arms.base.BaseApplication;

import me.jessyan.mvparms.demo.utils.AFUtils;

public class DemoApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        AFUtils.init(getApplicationContext());
    }
}
