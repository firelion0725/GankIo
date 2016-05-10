package com.leo.gank.comm.dagger;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Scope;

/**
 * Created by leo on 2016/4/12
 * Function
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
