package com.leo.gank.view.today.dagger;

import com.leo.gank.view.today.TodayFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/28
 * Function
 */
@Singleton
@Component(modules = TodayModules.class)
public interface TodayComponents {
    TodayFragment inject(TodayFragment fragment);
}
