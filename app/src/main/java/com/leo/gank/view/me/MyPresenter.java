package com.leo.gank.view.me;

import com.leo.gank.comm.realm.RealmUtils;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.me.MyCache;
import com.leo.gank.model.comm.GankModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by leo on 2016/5/10
 * Function
 */
public class MyPresenter extends BasePresenter implements MyImpl {

    MyFragment fragment;

    public MyPresenter(MyFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    protected void initData() {
        loadData();
    }

    private void loadData() {

        Observable.concat(MyCache.getObservable(), getDataBaseObservable())
                .takeFirst(new Func1<List<GankModel>, Boolean>() {
                    @Override
                    public Boolean call(List<GankModel> gankModels) {
                        return !Utils.ListUtils.isEmpty(gankModels);
                    }
                })
                .subscribe(new Action1<List<GankModel>>() {
                    @Override
                    public void call(List<GankModel> gankModels) {
                        refreshRecycler(gankModels);
                    }
                });
    }

    public void refresh() {
        loadMyCollect();
    }

    private void loadMyCollect() {
        openRefresh();
        getDataBaseObservable().subscribe(new Action1<List<GankModel>>() {
            @Override
            public void call(List<GankModel> gankModels) {
                HashMap<String, GankModel> map = new HashMap<>();
                for (GankModel model : gankModels) {
                    map.put(model.get_id(), model);
                }
                MyCache.setCollectCache(map);
                refreshRecycler(gankModels);
                closeRefresh();
            }
        });
    }

    private Observable<List<GankModel>> getDataBaseObservable() {
        Realm realm = RealmUtils.getRealmInstance();
        final RealmResults<GankModel> gankModels = realm.where(GankModel.class).findAll();
        return Observable.create(new Observable.OnSubscribe<List<GankModel>>() {
            @Override
            public void call(Subscriber<? super List<GankModel>> subscriber) {
                subscriber.onNext(gankModels);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public void openRefresh() {
        fragment.openRefresh();
    }

    @Override
    public void closeRefresh() {
        fragment.closeRefresh();
    }

    @Override
    public void refreshRecycler(List<GankModel> list) {
        fragment.refreshRecycler(list);
    }
}
