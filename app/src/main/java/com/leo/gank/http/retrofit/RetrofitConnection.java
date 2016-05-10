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

    private static class ClientHolder{
        private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(OkHttpConnection.getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        private static Retrofit getRetrofitInstance(OkHttpClient client){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(client)
                    .build();
            return retrofit;
        }

        private static Retrofit getRetrofitInstance(OkHttpClient client,String BaseUrl){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(client)
                    .build();
            return retrofit;
        }

        private static Retrofit getRetrofitInstance(String BaseUrl){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .build();
            return retrofit;
        }

    }

    public static final Retrofit getRetrofitClient(){
        return ClientHolder.retrofit;
    }

    public static final Retrofit getRetrofitClient(OkHttpClient client){
        return ClientHolder.getRetrofitInstance(client);
    }

    public static final Retrofit getRetrofitClient(String BaseUrl){
        return ClientHolder.getRetrofitInstance(BaseUrl);
    }

    public static final Retrofit getRetrofitClient(OkHttpClient client,String BaseUrl){
        return ClientHolder.getRetrofitInstance(client,BaseUrl);
    }



}
