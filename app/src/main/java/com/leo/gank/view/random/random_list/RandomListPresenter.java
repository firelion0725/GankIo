package com.leo.gank.view.random.random_list;

import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.random.RandomCache;
import com.leo.gank.data.random.RandomServiceToModel;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.data.DataModel;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by leo on 2016/4/26
 * Function
 */
public class RandomListPresenter extends BasePresenter implements RandomListImpl {

    RandomListFragment fragment;

    public RandomListPresenter(RandomListFragment fragment) {
        this.fragment = fragment;
    }

    private String type;

    public void setType(String str) {
        this.type = str;
    }

    protected void initData() {
        //concat内的网络请求不生效 原因不明

//        Observable<DataModel> observable = Observable.concat(RandomCache.getCacheObservable(type), RandomServiceToModel.getRandomData(type, 20))
//                .takeFirst(new Func1<DataModel, Boolean>() {
//                    @Override
//                    public Boolean call(DataModel DataModel) {
//                        return DataModel.getResults() != null && !DataModel.getResults().isEmpty();
//                    }
//                });
//        observable.subscribe(new Action1<DataModel>() {
//            @Override
//            public void call(DataModel DataModel) {
//                refreshRecycler(DataModel.getResults());
//            }
//        });

        if (RandomCache.getCache(type) == null
                || Utils.ListUtils.isEmpty(RandomCache.getCache(type).getResults())) {
            loadData();
        } else {
            refreshRecycler(RandomCache.getCache(type).getResults());
        }

    }

    public void loadData() {
        openRefresh();
        Observable<DataModel> observable = RandomServiceToModel.getRandomData(type, 20);
        observable.subscribe(new Subscriber<DataModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.getLocalizedMessage();
                closeRefresh();
            }

            @Override
            public void onNext(DataModel DataModel) {
                refreshRecycler(DataModel.getResults());
                RandomCache.setCache(type, DataModel);
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
