package com.leo.gank.view.history;

import com.leo.gank.comm.Constants;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.history.HistoryCache;
import com.leo.gank.data.history.HistoryServiceToModel;
import com.leo.gank.model.comm.GankModel;

import java.util.List;

import rx.Observable;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public class HistoryPresenter extends BasePresenter implements HistoryImpl {

    private HistoryFragment fragment;
    private int page = 1;

    public HistoryPresenter(HistoryFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    protected void initData() {

        Observable.concat(HistoryCache.getObservable(page), HistoryServiceToModel.getData(Constants.Type.WELFARE, page))
                .takeFirst(dataModel -> dataModel != null && !Utils.ListUtils.isEmpty(dataModel.getResults()))
                .subscribe(dataModel -> {
                    refresh(dataModel.getResults());
                    page++;
                });
    }
    @Override
    public void refresh(List<GankModel> girls) {
        fragment.refresh(girls);
    }

    @Override
    public void reSet(List<GankModel> girls) {
        fragment.reSet(girls);
    }
}
