package com.leo.gank.view.main.dagger;

import com.leo.gank.view.main.MainActivity;
import com.leo.gank.view.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/4/25
 * Function
 */
@Module
public class MainModules {
    MainActivity activity;

    public MainModules(MainActivity activity) {
        this.activity = activity;
    }

    @Singleton
    @Provides
    MainActivity getActivity() {
        return activity;
    }

    @Singleton
    @Provides
    MainPresenter getPresenter() {
        return new MainPresenter(activity);
    }
}
