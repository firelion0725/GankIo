package com.leo.gank.data.random;

import com.leo.gank.model.data.DataModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by leo on 2016/4/11
 * Function 获取随机数据接口
 * eg http://gank.io/api/random/data/Android/20
 */
interface RandomService {
    @GET("random/data/{type}/{num}")
    Observable<DataModel> getRandom(@Path("type") String type, @Path("num") int num);
}
