package com.leo.gank.model.history;

import com.leo.gank.comm.model.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * Created by leo on 2016/4/11
 * Function 历史数据实体
 */
public class HistoryModel extends BaseModel {

    /**
     * error : false
     * results : ["2016-04-08","2016-04-07",……,"2015-06-29","2015-05-18"]
     */

    private List<Date> results;

    public List<Date> getResults() {
        return results;
    }

    public void setResults(List<Date> results) {
        this.results = results;
    }
}
