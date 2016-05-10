package com.leo.gank.view.random.dagger;

import com.leo.gank.view.random.RandomFragment;
import com.leo.gank.view.random.RandomPresenter;
import com.leo.gank.view.random.random_list.RandomListFragment;
import com.leo.gank.view.random.random_list.RandomListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/4/26
 * Function
 */
@Module
public class RandomListModules {
    RandomListFragment fragment;

    public RandomListModules(RandomListFragment fragment) {
        this.fragment = fragment;
    }

    @Singleton
    @Provides
    RandomListFragment getRandom() {
        return fragment;
    }

    @Singleton
    @Provides
    RandomListPresenter getPresenter() {
        return new RandomListPresenter(fragment);
    }
}
