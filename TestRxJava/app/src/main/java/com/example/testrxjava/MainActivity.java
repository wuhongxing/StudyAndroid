package com.example.testrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.security.auth.Subject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;

class CabinetUtils {

    private static CabinetUtils cabinetUtils = new CabinetUtils();
    private CabinetUtils() {

    }
    public static synchronized CabinetUtils getInstance() {
        return cabinetUtils;
    }
    private XBY xby = new XBY();
    PublishSubject<Intent> subject = null;

    void queryBox() {
        xby.queryBox();
    }

    PublishSubject queryBox1() {
        return xby.queryBox1();
    }
}

class XBY {
    PublishSubject<Intent> subject = PublishSubject.create();

    void queryBox() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("id", 20);

                ECCommandManager.getInstance().callCommand(intent);
            }
        }, 1000);
    }

    PublishSubject queryBox1() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("id", 20);
                subject.onNext(intent);
                System.out.println("超时了，不该执行了");
//                Intent intent = new Intent();
//                intent.putExtra("id", 20);
//                ECCommandManager.getInstance().callCommand(intent);
            }
        }, 6000);
        return subject;
    }
}

class ECCommandManager {
    private ECCommandManager() { }
    private static ECCommandManager manager=new ECCommandManager();
    public static synchronized ECCommandManager getInstance(){ return manager; }
    private CopyOnWriteArrayList<ECListener> ecListeners=new CopyOnWriteArrayList<ECListener>();

    void register(ECListener e) { ecListeners.add(e); }
    void unRegister(ECListener e) { ecListeners.remove(e); }
    void callCommand(Intent intent) {
        for (ECListener e: ecListeners) {
            e.onBack(intent);
        }
    }
}

abstract class ECListener {
    abstract void onBack(Intent intent);
}

public class MainActivity extends AppCompatActivity {

    ECListener listener = new ECListener() {
        @Override
        void onBack(Intent intent) {
            System.out.println(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CabinetUtils.getInstance().subject.subscribe(new Consumer<Intent>() {
//            @Override
//            public void accept(Intent intent) throws Exception {
//                System.out.println(intent.getIntExtra("id", 100));
//            }
//        });
//        CabinetUtils.getInstance().queryBox1();
        System.out.println("开始");
        CabinetUtils.getInstance().queryBox1().retryWhen(new RetryWhenFun()).subscribe(new Consumer<Intent>() {
            @Override
            public void accept(Intent o) throws Exception {
                System.out.println(o.getIntExtra("id", 100));
            }
        });
        System.out.println("结束");
//        ECCommandManager.getInstance().register(listener);
//        CabinetUtils.getInstance().queryBox();
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                ECCommandManager.getInstance().unRegister(listener);
//            }
//        }, 5000);

//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        RxTest.getInstance().post("嘿嘿嘿");
//                    }
//                }, 2000);
//            }
//        });
//
//        RxTest.getInstance().getObservable().subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String value) {
//                System.out.println(value);
//                System.out.println(Thread.currentThread());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}


class RetryWhenFun implements io.reactivex.functions.Function<Observable<? extends Throwable>, Observable<?>> {
    private static final int DEFAULT_RETRY_COUNT = 3;
    private static final int DEFAULT_RETRY_DELAY = 3000;
    private static final int DEFAULT_RETRY_INCREASE_DELAY = 2000;
    //retry次数
    private int reTryCount;
    //延迟
    private long delay;
    //叠加延迟
    private long increaseDelay;

    public RetryWhenFun() {
    }

    public RetryWhenFun(int count, long delay) {
        this.reTryCount = count;
        this.delay = delay;
    }

    public RetryWhenFun(int count, long delay, long increaseDelay) {
        this.reTryCount = count;
        this.delay = delay;
        this.increaseDelay = increaseDelay;
    }

    @Override
    public Observable<?> apply(Observable<? extends Throwable> observable) throws Exception {
        if (reTryCount <= 0) {
            reTryCount = DEFAULT_RETRY_COUNT;
        }

        if (delay <= 0) {
            delay = DEFAULT_RETRY_DELAY;
        }

        if (increaseDelay <= 0) {
            increaseDelay = DEFAULT_RETRY_INCREASE_DELAY;
        }

        return observable
                .zipWith(Observable.range(1, reTryCount + 1), new BiFunction<Throwable, Integer, Wrapper>() {
                    @Override
                    public Wrapper apply(Throwable throwable, Integer integer) throws Exception {
                        return new Wrapper(throwable, integer);
                    }

                }).flatMap(new Function<Wrapper, ObservableSource<?>>() {
                    @Override
                    public Observable<?> apply(Wrapper wrapper) {
                        if ((wrapper.throwable instanceof ConnectException
                                || wrapper.throwable instanceof SocketTimeoutException
                                || wrapper.throwable instanceof TimeoutException)
                                && wrapper.index < reTryCount + 1) { //如果超出重试次数也抛出错误，否则默认是会进入onCompleted
                            return Observable.timer(delay + (wrapper.index - 1) * increaseDelay, TimeUnit.MILLISECONDS);

                        }
                        return Observable.error(wrapper.throwable);
                    }
                });
    }


    private class Wrapper {
        private int index;
        private Throwable throwable;

        public Wrapper(Throwable throwable, int index) {
            this.index = index;
            this.throwable = throwable;
        }
    }
}
