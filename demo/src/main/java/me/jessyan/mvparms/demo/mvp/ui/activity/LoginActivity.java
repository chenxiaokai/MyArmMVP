package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import me.jessyan.mvparms.demo.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_log_google)
    TextView tv_log_google;

    @BindView(R.id.tv_log_vistor)
    TextView tv_log_vistor;

    @BindView(R.id.iv_login_read_check)
    ImageView iv_login_read_check;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        tv_log_google.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_log_google:
                ArmsUtils.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
