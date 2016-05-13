package com.leo.gank.data.day;

import com.leo.gank.model.day.DayModel;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/29
 * Function
 */
public class DayCache {

    public static class Cache {
        static HashMap<String, DayModel> map = new HashMap<>();
    }


    public static Observable<DayModel> getCacheObservable(final String time) {
        return Observable.create(new Observable.OnSubscribe<DayModel>() {
            @Override
            public void call(Subscriber<? super DayModel> subscriber) {
                subscriber.onNext(getDayModelCache(time));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 通过时间获取该时间的数据缓存
     *
     * @param time 时间参数
     * @return 如果有历史数据就返回 如果没有则为null
     */
    public static DayModel getDayModelCache(String time) {
        return Cache.map.get(time);
    }

    public static void setDayModelCache(String time, DayModel dayModel) {
        Cache.map.put(time, dayModel);
    }
}
