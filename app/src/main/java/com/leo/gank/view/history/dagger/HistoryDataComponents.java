package com.leo.gank.view.history.dagger;

import com.leo.gank.view.history.day.HistoryDataActivity;
import com.leo.gank.view.today.TodayFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo on 2016/4/28
 * Function
 */
@Singleton
@Component(modules = HistoryDataModules.class)
public interface HistoryDataComponents {
    HistoryDataActivity inject(HistoryDataActivity activity);
}
