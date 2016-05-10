package com.leo.gank.view.me.dagger;

import com.leo.gank.view.me.MyFragment;
import com.leo.gank.view.me.MyPresenter;
import com.leo.gank.view.today.TodayFragment;
import com.leo.gank.view.today.TodayPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/5/10
 * Function
 */
@Module
public class MyModules {

    MyFragment fragment;

    public MyModules(MyFragment fragment) {
        this.fragment = fragment;
    }

    @Singleton
    @Provides
    MyFragment getFragment() {
        return fragment;
    }

    @Singleton
    @Provides
    MyPresenter getPresenter() {
        return new MyPresenter(fragment);
    }
}
