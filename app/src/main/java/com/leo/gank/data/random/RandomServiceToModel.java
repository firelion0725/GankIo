package com.leo.gank.data.random;

import com.leo.gank.http.retrofit.RetrofitConnection;
import com.leo.gank.model.data.DataModel;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leo on 2016/4/11
 * Function 将随机数据的网络数据转为Rx数据
 */
public class RandomServiceToModel {

    public static Observable<DataModel> getRandomData(String type, int num) {
        RandomService service = RetrofitConnection.getRetrofitClient().create(RandomService.class);

        return service.getRandom(type, num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
