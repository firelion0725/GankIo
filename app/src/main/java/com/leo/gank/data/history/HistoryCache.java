package com.leo.gank.data.history;

import com.leo.gank.model.data.DataModel;
import com.leo.gank.model.history.HistoryModel;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/11
 * Function
 */
public class HistoryCache {

    private static class Cache {
        static HistoryModel historyModelCache = new HistoryModel();
        static HashMap<Integer, DataModel> girlMap = new HashMap<>();
    }

    public static HistoryModel getHistoryCache() {
        return Cache.historyModelCache;
    }

    public static void setHistoryCache(HistoryModel model) {
        Cache.historyModelCache = model;
    }

    private static DataModel getGirlList(int page) {
        return Cache.girlMap.get(page);
    }

    public static void setGirlList(int page, DataModel girlList) {
        Cache.girlMap.put(page, girlList);
    }

    public static Observable<DataModel> getObservable(final int page) {
        return Observable.create(new Observable.OnSubscribe<DataModel>() {
            @Override
            public void call(Subscriber<? super DataModel> subscriber) {
                subscriber.onNext(getGirlList(page));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
