package com.leo.gank.view.me;

import com.leo.gank.model.comm.GankModel;

import java.util.List;

/**
 * Created by leo on 2016/5/10
 * Function
 */
interface MyImpl {
    void openRefresh();

    void closeRefresh();

    void refreshRecycler(List<GankModel> list);
}
