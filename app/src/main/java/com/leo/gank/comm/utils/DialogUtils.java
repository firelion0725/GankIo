package com.leo.gank.comm.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by leo on 2016/5/10
 * Function
 */
public class DialogUtils {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int rid) {
        Toast.makeText(context, rid, Toast.LENGTH_SHORT).show();
    }
}
