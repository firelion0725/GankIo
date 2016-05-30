package com.leo.gank.data.me;

import com.leo.gank.comm.utils.Utils;
import com.leo.gank.data.random.RandomCache;
import com.leo.gank.model.comm.GankModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/5/9
 * Function
 */
public class MyCache {

    private static class Cache {
        static HashMap<String, GankModel> MyCollectCacheList = new HashMap<>();
    }

    public static void setCollectCache(HashMap<String, GankModel> map) {
        Cache.MyCollectCacheList = map;
    }

    private static HashMap<String, GankModel> getCollectCache() {
        return Cache.MyCollectCacheList;
    }

    public static void putCollectCache(GankModel model) {
        Cache.MyCollectCacheList.put(model.get_id(), model);
    }

    public static void removeCollectCache(GankModel model) {
        Cache.MyCollectCacheList.remove(model.get_id());
    }

    public static boolean isHas(String id) {
        boolean isHas = false;
        if (!Utils.MapUtils.isEmpty(Cache.MyCollectCacheList)) {
            isHas = Cache.MyCollectCacheList.containsKey(id);
        }
        return isHas;
    }

    public static Observable<List<GankModel>> getObservable(){
        return Observable.create(new Observable.OnSubscribe<List<GankModel>>() {
            @Override
            public void call(Subscriber<? super List<GankModel>> subscriber) {
                subscriber.onNext(new ArrayList<>(getCollectCache().values()));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
