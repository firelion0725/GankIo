package com.leo.gank.http.retrofit;

import com.leo.gank.http.okhttp.OkHttpConnection;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leo on 2016/4/1
 * Function retrofit基础类
 */
public class RetrofitConnection {

    private static final String BaseUrl = "http://gank.io/api/";

    private static class ClientHolder {
        private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(OkHttpConnection.getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        private static Retrofit getRetrofitInstance(OkHttpClient client) {
            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(client)
                    .build();
        }

        private static Retrofit getRetrofitInstance(OkHttpClient client, String BaseUrl) {
            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(client)
                    .build();
        }

        private static Retrofit getRetrofitInstance(String BaseUrl) {
            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .build();
        }

    }

    public static Retrofit getRetrofitClient() {
        return ClientHolder.retrofit;
    }

    public static Retrofit getRetrofitClient(OkHttpClient client) {
        return ClientHolder.getRetrofitInstance(client);
    }

    public static Retrofit getRetrofitClient(String BaseUrl) {
        return ClientHolder.getRetrofitInstance(BaseUrl);
    }

    public static Retrofit getRetrofitClient(OkHttpClient client, String BaseUrl) {
        return ClientHolder.getRetrofitInstance(client, BaseUrl);
    }


}
