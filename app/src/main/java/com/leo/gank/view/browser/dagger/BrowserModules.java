package com.leo.gank.view.browser.dagger;

import com.leo.gank.view.browser.BrowserActivity;
import com.leo.gank.view.browser.BrowserPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/4/28
 * Function
 */
@Module
public class BrowserModules {

    BrowserActivity activity;

    public BrowserModules(BrowserActivity activity) {
        this.activity = activity;
    }

    @Singleton
    @Provides
    BrowserActivity getActivity() {
        return activity;
    }

    @Singleton
    @Provides
    BrowserPresenter getPresenter() {
        return new BrowserPresenter(activity);
    }
}
