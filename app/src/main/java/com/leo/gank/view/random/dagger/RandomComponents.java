package com.leo.gank.view.random.dagger;

import com.leo.gank.view.random.RandomFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/25
 * Function
 */
@Singleton
@Component(modules = RandomModules.class)
public interface RandomComponents {
    RandomFragment inject(RandomFragment fragment);
}
