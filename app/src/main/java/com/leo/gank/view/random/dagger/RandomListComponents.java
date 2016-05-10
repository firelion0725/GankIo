package com.leo.gank.view.random.dagger;

import com.leo.gank.view.random.random_list.RandomListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/26
 * Function
 */
@Singleton
@Component(modules = RandomListModules.class)
public interface RandomListComponents {
    RandomListFragment inject(RandomListFragment fragment);
}
