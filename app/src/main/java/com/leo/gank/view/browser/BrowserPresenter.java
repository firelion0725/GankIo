package com.leo.gank.view.browser;

import android.util.Log;
import android.widget.Toast;

import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.realm.RealmUtils;
import com.leo.gank.comm.utils.DialogUtils;
import com.leo.gank.comm.view.BasePresenter;
import com.leo.gank.data.me.MyCache;
import com.leo.gank.model.comm.GankModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by leo on 2016/5/9
 * Function
 */
public class BrowserPresenter extends BasePresenter implements BrowserImpl {

    BrowserActivity activity;

    GankModel model;

    Realm realm;

    public BrowserPresenter(BrowserActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void initData() {
        realm = RealmUtils.getRealmInstance();
        model = activity.getIntent().getParcelableExtra(Constants.Argument.MODEL);

        setToolBar(model.getDesc(), MyCache.isHas(model.get_id()));
        loadUrl(model.getUrl());
    }

    @Override
    public void setToolBar(String desc, boolean isCollect) {
        activity.setToolBar(desc, isCollect);
    }

    @Override
    public void loadUrl(String url) {
        activity.loadUrl(url);
    }


    public void write() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealmOrUpdate(model);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                DialogUtils.showToast(activity, R.string.collect_add);
                MyCache.putCollectCache(model);
                setToolBar(model.getDesc(), true);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.i("error", "" + error.getMessage());
                Toast.makeText(activity, "OnError:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void delete() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                GankModel m = bgRealm.copyToRealmOrUpdate(model);
                m.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                DialogUtils.showToast(activity, R.string.collect_cancel);
                MyCache.removeCollectCache(model);
                setToolBar(model.getDesc(),false);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.i("error", "" + error.getMessage());
                Toast.makeText(activity, "OnError:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
