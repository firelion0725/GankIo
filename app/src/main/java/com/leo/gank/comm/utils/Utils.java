package com.leo.gank.comm.utils;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * Created by leo on 2016/4/27
 * Function
 */
public class Utils {


    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static class ListUtils {
        /**
         * 判断一个List是否为空
         *
         * @param list 需要判断的List对象
         * @return 如果List为nul 或者size为0 返回true 否则为 false
         */
        public static boolean isEmpty(List list) {
            return list == null || list.size() == 0;
        }
    }

    public static class MapUtils {
        /**
         * 判断一个List是否为空
         *
         * @param map 需要判断的Map对象
         * @return 如果Map为nul 或者size为0 返回true 否则为 false
         */
        public static boolean isEmpty(Map map) {
            return map == null || map.size() == 0;
        }
    }
}
