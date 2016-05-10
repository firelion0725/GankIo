package com.leo.gank.view.today.dagger;

import com.leo.gank.view.today.TodayFragment;
import com.leo.gank.view.today.TodayPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/4/28
 * Function
 */
@Module
public class TodayModules {

    TodayFragment fragment;

    public TodayModules(TodayFragment fragment) {
        this.fragment = fragment;
    }

    @Singleton
    @Provides
    TodayFragment getFragment() {
        return fragment;
    }

    @Singleton
    @Provides
    TodayPresenter getPresenter() {
        return new TodayPresenter(fragment);
    }
}
