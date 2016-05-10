package com.leo.gank.data.history;

import com.leo.gank.http.retrofit.RetrofitConnection;
import com.leo.gank.model.data.DataModel;
import com.leo.gank.model.history.HistoryModel;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/11
 * Function 历史数据的网络数据转为Rx数据
 */
public class HistoryServiceToModel {

    public static Observable<HistoryModel> getHistory(){
        HistoryService service = RetrofitConnection.getRetrofitClient().create(HistoryService.class);
        Observable<HistoryModel> history = service.getHistory()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return history;
    }

    private static final int NUM = 10;

    public static Observable<DataModel> getData(String type, int page) {
        HistoryService service = RetrofitConnection.getRetrofitClient()
                .create(HistoryService.class);

        return service.getData(type, NUM, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
