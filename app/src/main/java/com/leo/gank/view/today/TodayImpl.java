package com.leo.gank.view.today;

import com.leo.gank.model.day.DayModel;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public interface TodayImpl {
    void updateView(DayModel model);
    void openRefresh();
    void closeRefresh();
}
