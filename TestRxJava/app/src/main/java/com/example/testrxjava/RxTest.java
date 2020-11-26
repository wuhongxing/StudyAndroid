package com.example.testrxjava;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class RxTest {
    private static volatile RxTest mInstance;
    private volatile Subject<String> mSubject = PublishSubject.create();

    private RxTest() {

    }

    public static RxTest getInstance() {
        if (mInstance == null) {
            mInstance = new RxTest();
        }
        return mInstance;
    }

    /**
     * 发送消息
     *
     * @param s
     */
    public void post(String s) {
        mSubject.onNext(s);
    }


    public Observable<String> getObservable() {
        return mSubject;
    }
}
