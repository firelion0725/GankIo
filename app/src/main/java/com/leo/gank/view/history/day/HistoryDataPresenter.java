package com.leo.gank.view.history.day;

import android.content.Intent;

import com.leo.gank.comm.Constants;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.day.DayCache;
import com.leo.gank.data.day.DayServiceToModel;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.today.TodayFragment;

import java.util.Calendar;
import java.util.Date;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by leo on 2016/5/4
 * Function
 */
public class HistoryDataPresenter extends BasePresenter implements HistoryDataImpl {

    HistoryDataActivity activity;
    String year, month, day;

    public HistoryDataPresenter(HistoryDataActivity activity) {
        this.activity = activity;
    }

    void init() {
        Intent intent = activity.getIntent();
        year = intent.getStringExtra(Constants.Argument.YEAR);
        month = intent.getStringExtra(Constants.Argument.MONTH);
        day = intent.getStringExtra(Constants.Argument.DAY);
    }

    @Override
    protected void initData() {
        loadData();
    }

    @Override
    public void updateView(DayModel model) {
        activity.updateView(model);
    }

    private void loadData() {
        String time = year + "-" + month + "-" + day;

        Observable.concat(DayCache.getCacheObservable(time)
                , DayServiceToModel.getDayData(year, month, day))
                .takeFirst(dayModel -> dayModel != null)
                .subscribe(dayModel -> updateView(dayModel));
    }
}
