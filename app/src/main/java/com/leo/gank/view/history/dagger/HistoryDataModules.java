package com.leo.gank.view.history.dagger;

import com.leo.gank.view.history.day.HistoryDataActivity;
import com.leo.gank.view.history.day.HistoryDataPresenter;
import com.leo.gank.view.today.TodayFragment;
import com.leo.gank.view.today.TodayPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo on 2016/4/28
 * Function
 */
@Module
public class HistoryDataModules {

    HistoryDataActivity activity;

    public HistoryDataModules(HistoryDataActivity activity) {
        this.activity = activity;
    }

    @Singleton
    @Provides
    HistoryDataActivity getFragment() {
        return activity;
    }

    @Singleton
    @Provides
    HistoryDataPresenter getPresenter() {
        return new HistoryDataPresenter(activity);
    }
}
