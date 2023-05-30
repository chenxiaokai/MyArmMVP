package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.ui.fragment.HomeFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rb_mian_home)
    AppCompatRadioButton rb_mian_home;
    @BindView(R.id.rb_mian_history)
    AppCompatRadioButton rb_mian_history;
    @BindView(R.id.rb_mian_find)
    AppCompatRadioButton rb_mian_find;
    @BindView(R.id.rb_mian_msg)
    AppCompatRadioButton rb_mian_msg;
    @BindView(R.id.rb_mian_mine)
    AppCompatRadioButton rb_mian_mine;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        rb_mian_home.setOnClickListener(this);
        rb_mian_history.setOnClickListener(this);
        rb_mian_find.setOnClickListener(this);
        rb_mian_msg.setOnClickListener(this);
        rb_mian_mine.setOnClickListener(this);

        replaceFragment(new HomeFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_mian_home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.rb_mian_history:

                break;
            case R.id.rb_mian_find:

                break;
            case R.id.rb_mian_msg:

                break;
            case R.id.rb_mian_mine:

                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fTransation = fragmentManager.beginTransaction();
        fTransation.replace(R.id.fl_content, fragment);
        fTransation.commit(); //提交才能执行
    }
}
