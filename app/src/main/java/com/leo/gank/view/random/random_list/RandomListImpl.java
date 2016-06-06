package com.leo.gank.view.random.random_list;

import com.leo.gank.model.comm.GankModel;

import java.util.List;

/**
 * Created by leo on 2016/4/26
 * Function
 */
interface RandomListImpl {

    void openRefresh();

    void closeRefresh();

    void refreshRecycler(List<GankModel> list);
}
