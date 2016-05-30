package com.leo.gank.data.day;

import com.leo.gank.model.day.DayModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by leo on 2016/4/11
 * Function 获取每日数据接口
 * eg http://gank.io/api/day/2015/08/06
 */
interface DayService {
    @GET("day/{year}/{month}/{day}")
    Observable<DayModel> getDay(@Path("year") String year
            , @Path("month") String month, @Path("day") String day);
}
