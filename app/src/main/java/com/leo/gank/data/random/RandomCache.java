package com.leo.gank.data.random;

import com.leo.gank.comm.Constants;
import com.leo.gank.model.data.DataModel;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/27
 * Function 随便看看里的缓存数据
 */
public class RandomCache {

    public static class Cache {
        static DataModel androidCache = new DataModel();
        static DataModel iosCache = new DataModel();
        static DataModel expandCache = new DataModel();
        static DataModel frontCache = new DataModel();
    }

    public static DataModel getCache(String type) {
        DataModel model = null;
        switch (type) {
            case Constants.Type.ANDROID:
                model = getAndroidCache();
                break;
            case Constants.Type.IOS:
                model = getIosCache();
                break;
            case Constants.Type.FRONT:
                model = getFrontCache();
                break;
            case Constants.Type.EXPAND:
                model = getExpandCache();
                break;
        }
        return model;
    }

    public static void setCache(String type, DataModel DataModel) {
        switch (type) {
            case Constants.Type.ANDROID:
                setAndroidCache(DataModel);
                break;
            case Constants.Type.IOS:
                setIosCache(DataModel);
                break;
            case Constants.Type.FRONT:
                setFrontCache(DataModel);
                break;
            case Constants.Type.EXPAND:
                setExpandCache(DataModel);
                break;
        }
    }

    public static Observable<DataModel> getCacheObservable(String type) {
        Observable<DataModel> observable = null;
        switch (type) {
            case Constants.Type.ANDROID:
                observable = getAndroidObservable();
                break;
            case Constants.Type.IOS:
                observable = getIosObservable();
                break;
            case Constants.Type.FRONT:
                observable = getFrontObservable();
                break;
            case Constants.Type.EXPAND:
                observable = getExpandObservable();
                break;
        }
        return observable;
    }

    public static Observable<DataModel> getAndroidObservable() {
        return Observable.create(new Observable.OnSubscribe<DataModel>() {
            @Override
            public void call(Subscriber<? super DataModel> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(getAndroidCache());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static void setAndroidCache(DataModel DataModel) {
        Cache.androidCache = DataModel;
    }

    private static DataModel getAndroidCache() {
        return Cache.androidCache;
    }

    private static Observable<DataModel> getIosObservable() {
        return Observable.create(new Observable.OnSubscribe<DataModel>() {
            @Override
            public void call(Subscriber<? super DataModel> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(getIosCache());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static void setIosCache(DataModel DataModel) {
        Cache.iosCache = DataModel;
    }

    private static DataModel getIosCache() {
        return Cache.iosCache;
    }

    private static Observable<DataModel> getExpandObservable() {
        return Observable.create(new Observable.OnSubscribe<DataModel>() {
            @Override
            public void call(Subscriber<? super DataModel> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(getExpandCache());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static void setExpandCache(DataModel DataModel) {
        Cache.expandCache = DataModel;
    }

    private static DataModel getExpandCache() {
        return Cache.expandCache;
    }

    private static Observable<DataModel> getFrontObservable() {
        return Observable.create(new Observable.OnSubscribe<DataModel>() {
            @Override
            public void call(Subscriber<? super DataModel> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(getFrontCache());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static void setFrontCache(DataModel DataModel) {
        Cache.frontCache = DataModel;
    }

    private static DataModel getFrontCache() {
        return Cache.frontCache;
    }
}
