package com.leo.gank.http.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by leo on 2016/4/1
 * Function okhttp基础类
 *
 */
public class OkHttpConnection {

    private static class ClientHolder{
        private static OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build();
    }

    public static final OkHttpClient getOkHttpClient(){
        return ClientHolder.client;
    }

}
