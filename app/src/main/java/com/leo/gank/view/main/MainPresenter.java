package com.leo.gank.view.main;

import com.leo.gank.comm.realm.RealmUtils;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.history.HistoryCache;
import com.leo.gank.data.history.HistoryServiceToModel;
import com.leo.gank.data.me.MyCache;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.history.HistoryModel;
import com.leo.gank.view.history.HistoryFragment;
import com.leo.gank.view.me.MyFragment;
import com.leo.gank.view.random.RandomFragment;
import com.leo.gank.view.today.TodayFragment;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by leo on 2016/4/25
 * Function
 */
public class MainPresenter extends BasePresenter implements MainImpl {

    private MainActivity activity;

    private BaseFragment currentFragment;
    private int index = -1;//当前fragment的标签号

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
    }

    public static class FragmentGroup {

        static TodayFragment todayFragment = new TodayFragment();
        static RandomFragment randomFragment = new RandomFragment();
        static HistoryFragment historyFragment = new HistoryFragment();
        static MyFragment myFragment = new MyFragment();

        static TodayFragment getTodayFragment() {
            return todayFragment;
        }

        static RandomFragment getRandomFragment() {
            return new RandomFragment();
        }

        static HistoryFragment getHistoryFragment() {
            return historyFragment;
        }

        static MyFragment getMeFragment() {
            return myFragment;
        }
    }

    private BaseFragment getFragment(int index) {

        switch (index) {
            case 0:
                return FragmentGroup.getTodayFragment();
            case 1:
                return FragmentGroup.getRandomFragment();
            case 2:
                return FragmentGroup.getHistoryFragment();
            case 3:
                return FragmentGroup.getMeFragment();
            default:
                return currentFragment;
        }
    }


    @Override
    protected void initData() {
        RealmUtils.initRealm(activity.getApplicationContext());
        loadHistoryData();
        loadMyCollect();
    }

    public void setFragment(int index) {
        if (index == MainPresenter.this.index) {
            return;
        }
        MainPresenter.this.index = index;
        //延时300毫秒加载fragment，保证主线程不阻塞
        Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                subscriber.onNext(200L);
            }
        }).delay(300, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Long aLong) {
                        BaseFragment fragment = getFragment(MainPresenter.this.index);
                        if (fragment != null) {
                            currentFragment = fragment;
                        }
                        activity.setCurrentFragment(currentFragment);
                    }
                });
    }

    private void loadHistoryData() {
        HistoryServiceToModel.getHistory().subscribe(new Subscriber<HistoryModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HistoryModel historyModel) {
                HistoryCache.setHistoryCache(historyModel);
                sendHistoryData();
            }
        });
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
            }
        });
    }

    @Override
    public void sendHistoryData() {
        activity.sendHistoryData();
    }
}
