package com.leo.gank.view.today;

import android.util.Log;

import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.day.DayCache;
import com.leo.gank.data.day.DayServiceToModel;
import com.leo.gank.model.day.DayModel;

import java.util.Calendar;
import java.util.Date;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public class TodayPresenter extends BasePresenter implements TodayImpl {

    TodayFragment fragment;
    String year, month, day;

    public TodayPresenter(TodayFragment fragment) {
        this.fragment = fragment;
    }

    public void init(Date date) {
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
        fragment.updateView(model);
    }

    @Override
    public void openRefresh() {
        fragment.openRefresh();
    }

    @Override
    public void closeRefresh() {
        fragment.closeRefresh();
    }

    public void loadData() {
        String time = year + "-" + month + "-" + day;

        Observable.concat(DayCache.getCacheObservable(time)
                , DayServiceToModel.getDayData(year, month, day))
//                .takeFirst(new Func1<DayModel, Boolean>() {
//                    @Override
//                    public Boolean call(DayModel dayModel) {
//                        Log.i("call", dayModel + "---" + (dayModel != null));
//                        return dayModel != null;
//                    }
//                })
                .takeFirst(dayModel -> dayModel != null)
//                .subscribe(new Action1<DayModel>() {
//            @Override
//            public void call(DayModel dayModel) {
//                updateView(dayModel);
//            }
//        });
                .subscribe(dayModel -> updateView(dayModel));

    }

    void loadDataFromNet() {
        openRefresh();
        DayServiceToModel.getDayData(year, month, day).subscribe(new Action1<DayModel>() {
            @Override
            public void call(DayModel dayModel) {
                String time = year + "-" + month + "-" + day;
                DayCache.setDayModelCache(time, dayModel);
                updateView(dayModel);
                closeRefresh();
            }
        });
    }
}
