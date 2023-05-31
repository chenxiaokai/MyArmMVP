package me.jessyan.mvparms.demo.mvp.contract;

import android.app.Activity;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.tbruyelle.rxpermissions2.RxPermissions;

public interface PopularContract {

    interface View extends IView {
        void startLoadMore();

        void endLoadMore();

        Activity getActivity();

        RxPermissions getRxPermissions();
    }

    interface Model extends IModel {

    }
}
