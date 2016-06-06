package com.leo.gank.comm.firebase;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by leo on 2016/6/6
 * Function
 */
public class FireBaseUtils {
    private static FirebaseAnalytics mFirebaseAnalytics;

    public static void initAnalytics(Context context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    /**
     * firebase demo
     */
    private static void sendDefaultAnalyticsLog(String id, String name) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }


    /**
     * 发送观看web的基础数据
     *
     * @param url  网页的链接地址
     * @param name 网页名称
     */
    public static void sendWebAnalyticsLog(String url, String name) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

}
