package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import java.util.Timer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.jessyan.mvparms.demo.R;

public class SplashActivity extends BaseActivity {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }
        }.sendEmptyMessageDelayed(1, 3000l);
    }

}
