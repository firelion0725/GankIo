package com.leo.gank.view.history;

import android.util.Log;

import com.leo.gank.comm.Constants;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.history.HistoryCache;
import com.leo.gank.data.history.HistoryServiceToModel;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.data.DataModel;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public class HistoryPresenter extends BasePresenter implements HistoryImpl {

    HistoryFragment fragment;
    int page = 1;

    public HistoryPresenter(HistoryFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    protected void initData() {
        if (Utils.ListUtils.isEmpty(HistoryCache.getGirlList(page))) {
            loadGirl();
        } else {
            refresh(HistoryCache.getGirlList(page));
            page++;
        }
    }


    private void loadGirl() {
        Observable<DataModel> observable = HistoryServiceToModel.getData(Constants.Type.WELFARE, page);
        observable.subscribe(new Subscriber<DataModel>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.i("aaaaa",""+e.getLocalizedMessage());
            }

            @Override
            public void onNext(DataModel dataModel) {
                HistoryCache.setGirlList(page,dataModel.getResults());
                page++;
                refresh(dataModel.getResults());
            }
        });
    }

//    private void loadVideo() {
//        Observable<List<GankModel>> observable = HistoryServiceToModel.getData(Constants.Type.VIEW, page);
//        observable.subscribe(new Subscriber<List<GankModel>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(List<GankModel> gankModels) {
//                HistoryCache.addvideoList(gankModels);
//                page++;
//
//            }
//        });
//    }

    @Override
    public void refresh(List<GankModel> girls) {
        fragment.refresh(girls);
    }

    @Override
    public void reSet(List<GankModel> girls) {
        fragment.reSet(girls);
    }
}
