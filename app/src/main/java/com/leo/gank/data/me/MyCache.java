package com.leo.gank.data.me;

import com.leo.gank.comm.utils.Utils;
import com.leo.gank.data.random.RandomCache;
import com.leo.gank.model.comm.GankModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leo on 2016/5/9
 * Function
 */
public class MyCache {

    public static class Cache {
        static HashMap<String, GankModel> MyCollectCacheList = new HashMap<>();
    }

    public static void setCollectCache(HashMap<String, GankModel> map) {
        Cache.MyCollectCacheList = map;
    }

    public static HashMap<String, GankModel> getCollectCache() {
        return Cache.MyCollectCacheList;
    }

    public static void putCollectCache(GankModel model) {
        Cache.MyCollectCacheList.put(model.get_id(), model);
    }

    public static void removeCollectCache(GankModel model) {
        Cache.MyCollectCacheList.remove(model.get_id());
    }

    public static boolean isHas(String id) {
        boolean isHas = false;
        if (!Utils.MapUtils.isEmpty(Cache.MyCollectCacheList)) {
            isHas = Cache.MyCollectCacheList.containsKey(id);
        }
        return isHas;
    }

}
