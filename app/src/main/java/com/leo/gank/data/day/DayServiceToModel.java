package com.leo.gank.data.day;

import com.leo.gank.http.retrofit.RetrofitConnection;
import com.leo.gank.model.day.DayModel;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/11
 * Function 将每日数据的网络数据转为Rx数据
 */
public class DayServiceToModel {
    public static Observable<DayModel> getDayData(String year,String month,String day) {
        DayService service = RetrofitConnection.getRetrofitClient().create(DayService.class);
        Observable<DayModel> dayData = service.getDay(year, month,day)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        return dayData;
    }
}
