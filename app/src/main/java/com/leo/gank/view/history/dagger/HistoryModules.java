package com.leo.gank.view.history.dagger;

import com.leo.gank.view.history.HistoryFragment;
import com.leo.gank.view.history.HistoryPresenter;
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
public class HistoryModules {
    HistoryFragment fragment;

    public HistoryModules(HistoryFragment fragment) {
        this.fragment = fragment;
    }

    @Singleton
    @Provides
    HistoryFragment getRandom() {
        return fragment;
    }

    @Singleton
    @Provides
    HistoryPresenter getPresenter() {
        return new HistoryPresenter(fragment);
    }
}
