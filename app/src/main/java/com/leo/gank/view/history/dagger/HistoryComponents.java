package com.leo.gank.view.history.dagger;

import com.leo.gank.view.history.HistoryFragment;
import com.leo.gank.view.random.RandomFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/25
 * Function
 */
@Singleton
@Component(modules = HistoryModules.class)
public interface HistoryComponents {
    HistoryFragment inject(HistoryFragment fragment);
}
