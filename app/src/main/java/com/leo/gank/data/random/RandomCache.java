package com.leo.gank.data.random;

import com.leo.gank.model.data.DataModel;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/27
 * Function 随便看看里的缓存数据
 */
public class RandomCache {

    private static class Cache {
        static HashMap<String, DataModel> mapCache = new HashMap<>();
    }

    private static DataModel getCache(String type) {
        return Cache.mapCache.get(type);
    }

    public static void setCache(String type, DataModel DataModel) {
        Cache.mapCache.put(type, DataModel);
    }

    public static Observable<DataModel> getObservable(final String type) {
        return Observable.create(new Observable.OnSubscribe<DataModel>() {
            @Override
            public void call(Subscriber<? super DataModel> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(getCache(type));
                    subscriber.onCompleted();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
