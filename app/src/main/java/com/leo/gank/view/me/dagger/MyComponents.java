package com.leo.gank.view.me.dagger;

import com.leo.gank.view.me.MyFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/5/10
 * Function
 */
@Singleton
@Component(modules = MyModules.class)
public interface MyComponents {
    MyFragment inject(MyFragment fragment);
}
