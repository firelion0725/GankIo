package com.leo.gank.comm.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by leo on 2016/5/6
 * Function
 */
public class RealmUtils {

    private static class RealmClient {
        static Realm realm;
    }

    public static Realm getRealmInstance() {
        return RealmClient.realm;
    }

    public static void initRealm(Context context) {
        RealmConfiguration configuration = new RealmConfiguration.Builder(context).build();
        RealmClient.realm = Realm.getInstance(configuration);
    }
}
