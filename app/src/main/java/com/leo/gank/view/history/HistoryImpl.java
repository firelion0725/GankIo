package com.leo.gank.view.history;

import com.leo.gank.model.comm.GankModel;

import java.util.List;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public interface HistoryImpl {

    void refresh(List<GankModel> girls);

    void reSet(List<GankModel> girls);
}
