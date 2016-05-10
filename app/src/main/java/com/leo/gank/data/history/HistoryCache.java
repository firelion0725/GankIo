package com.leo.gank.data.history;

import android.os.Parcelable;

import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.history.HistoryModel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by leo on 2016/4/11
 * Function
 */
public class HistoryCache {

    private static class Cache {
        static Parcelable RandomViewPagerAdapterSave;
        static HistoryModel historyModelCache = new HistoryModel();
        static HashMap<Integer, List<GankModel>> girlMap = new HashMap<>();
    }

    public static HistoryModel getHistoryCache() {
        return Cache.historyModelCache;
    }

    public static void setHistoryCache(HistoryModel model) {
        Cache.historyModelCache = model;
    }

    public static List<GankModel> getGirlList(int page) {
        return Cache.girlMap.get(page);
    }

    public static void setGirlList(int page, List<GankModel> girlList) {
        Cache.girlMap.put(page, girlList);
    }

    public static void setRandomViewPagerAdapterSave(Parcelable parcelable){
        Cache.RandomViewPagerAdapterSave = parcelable;
    }

    public static Parcelable getRandomViewPagerAdapterSave(){
        return Cache.RandomViewPagerAdapterSave;
    }


}
