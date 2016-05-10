package com.leo.gank.comm.rxjava;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public class RxBus {
    //private final PublishSubject<Object> subject = PublishSubject.create();

    // If multiple threads are going to emit events to this
    // then it must be made thread-safe like this instead
    private final Subject<Object, Object> subject = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        subject.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return subject;
    }

    public boolean hasObservers() {
        return subject.hasObservers();
    }

    public Observable<Object> subscribe() {
        return subject;
    }
}
