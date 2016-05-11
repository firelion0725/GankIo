package com.leo.gank.view.history.day;

import com.leo.gank.comm.Constants;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.day.DayCache;
import com.leo.gank.data.day.DayServiceToModel;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.today.TodayFragment;

import java.util.Calendar;
import java.util.Date;

import rx.functions.Action1;

/**
 * Created by leo on 2016/5/4
 * Function
 */
public class HistoryDataPresenter extends BasePresenter implements HistoryDataImpl {

    HistoryDataActivity activity;
    GankModel model;
    String year, month, day;

    public HistoryDataPresenter(HistoryDataActivity activity) {
        this.activity = activity;
    }

    public void init() {
        model = activity.getIntent().getParcelableExtra(Constants.Argument.MODEL);
        Date date = model.getPublishedAt();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    protected void initData() {
        loadData();
    }

    @Override
    public void updateView(DayModel model) {
        activity.updateView(model);
    }

    public void loadData() {
        String time = year + "-" + month + "-" + day;

        if (DayCache.getDayModelCache(time) != null) {
            updateView(DayCache.getDayModelCache(time));
        } else {
            loadDataFromNet();
        }
    }


    private void loadDataFromNet() {
        DayServiceToModel.getDayData(year, month, day).subscribe(new Action1<DayModel>() {
            @Override
            public void call(DayModel dayModel) {
                String time = year + "-" + month + "-" + day;
                DayCache.setDayModelCache(time, dayModel);
                updateView(dayModel);
            }
        });
    }
}
