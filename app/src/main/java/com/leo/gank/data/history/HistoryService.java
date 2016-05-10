package com.leo.gank.data.history;

import com.leo.gank.model.data.DataModel;
import com.leo.gank.model.history.HistoryModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by leo on 2016/4/11
 * Function 历史数据接口
 * eg http://gank.io/api/day/history
 */
public interface HistoryService {

    @GET("day/history")
    Observable<HistoryModel> getHistory();

    @GET("data/{type}/{num}/{page}")
    Observable<DataModel> getData(@Path("type") String type, @Path("num") int num, @Path("page") int page);
}
