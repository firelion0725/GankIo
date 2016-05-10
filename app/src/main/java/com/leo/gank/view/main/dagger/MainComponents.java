package com.leo.gank.view.main.dagger;

import com.leo.gank.view.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/25
 * Function
 */
@Singleton
@Component(modules = MainModules.class)
public interface MainComponents {
    MainActivity inject(MainActivity activity);
}
