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
import rx.functions.Action1;

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
        if (Utils.MapUtils.isEmpty(MyCache.getCollectCache())) {
            loadMyCollect();
        } else {
            List<GankModel> list = new ArrayList<>(MyCache.getCollectCache().values());
            refreshRecycler(list);
        }
    }

    public void refresh() {
        openRefresh();
        loadMyCollect();
        List<GankModel> list = new ArrayList<>(MyCache.getCollectCache().values());
        refreshRecycler(list);
    }

    private void loadMyCollect() {
        Realm realm = RealmUtils.getRealmInstance();

        RealmResults<GankModel> gankModels = realm.where(GankModel.class).findAll();
        gankModels.asObservable().subscribe(new Action1<RealmResults<GankModel>>() {
            @Override
            public void call(RealmResults<GankModel> gankModels) {
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
