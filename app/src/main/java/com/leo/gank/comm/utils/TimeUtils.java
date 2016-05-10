package com.leo.gank.comm.utils;

import java.util.Date;
import java.util.Locale;

/**
 * Created by leo on 2016/5/3
 * Function
 */
public class TimeUtils {

    /**
     * 日期转型
     *
     * @param date 日期
     * @return 输出格式为 yyyy-mm-dd
     */
    public static String formatDate(Date date) {
        return String.format("%tF", date);
    }

    /**
     * 时间转型
     *
     * @param date 时间 默认时区为中国
     * @return 输出格式 HH:MM:SS
     */
    public static String formatTime(Date date) {
        return String.format(Locale.CHINA, "%tT", date);
    }


    public static String formatDateAndTime(Date date) {
        return formatDate(date) + " " + formatTime(date);
    }
}
