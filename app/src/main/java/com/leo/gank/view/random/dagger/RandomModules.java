package com.leo.gank.view.random.dagger;

import com.leo.gank.view.random.RandomFragment;
import com.leo.gank.view.random.RandomPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/4/25
 * Function
 */
@Module
public class RandomModules {
    RandomFragment fragment;

    public RandomModules(RandomFragment fragment) {
        this.fragment = fragment;
    }

    @Singleton
    @Provides
    RandomFragment getRandom() {
        return fragment;
    }

    @Singleton
    @Provides
    RandomPresenter getPresenter() {
        return new RandomPresenter(fragment);
    }
}
