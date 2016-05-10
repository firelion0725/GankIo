package com.leo.gank.view.browser.dagger;

import com.leo.gank.view.browser.BrowserActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/28
 * Function
 */
@Singleton
@Component(modules = BrowserModules.class)
public interface BrowserComponents {
    BrowserActivity inject(BrowserActivity activity);
}
