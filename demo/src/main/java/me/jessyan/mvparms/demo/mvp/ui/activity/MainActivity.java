package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.os.Bundle;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.jessyan.mvparms.demo.R;

public class MainActivity extends BaseActivity {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

}
