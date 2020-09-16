package com.example.cniao5play;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cniao5play.Dragger2.Component;
import com.example.cniao5play.Dragger2.Service;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.tls.OkHostnameVerifier;

public class MainActivity extends AppCompatActivity {

    @Inject
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DraggerComponent.create().inject(this);
        service.start();
    }

    private void okhttpUse() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("").build();
        Call call = okHttpClient.newCall(request);
        // 异步处理方式
        // 第一条主线: 请求发到哪里去了 - 被发送到了运行队列或等待队列中
        // 第二条主线: 请求是谁处理的 - 注意：无容量的线程池的原因（我们自己已经有运行/等待队列了，就没有必要再使用系统的队列了）
        // excute 处理请求: 责任链模式
        // 第三条主线: 请求是怎么维护的 - 靠线程结束来给维护的
        // 性能的提升是封装了 socket，其他的框架使用的可能是 HTTPURLConnection，牛逼之处在于拦截器的思想
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("请求失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String content = response.body().string();
                System.out.println("请求成功" + content);
            }
        });
    }
}