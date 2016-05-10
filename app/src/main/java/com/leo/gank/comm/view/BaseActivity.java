package com.leo.gank.comm.view;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by leo on 2016/4/11
 * Function
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initData();
    protected abstract void setDataForViews();

}
