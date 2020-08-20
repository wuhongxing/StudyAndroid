package com.example.firstlineofandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity3 extends AppCompatActivity {

    private ViewPager vp;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] datas = new int[Images.imageArray.length + 2];

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initData();

        vp = (ViewPager)findViewById(R.id.vp);
        // 适配器
        viewPagerAdapter = new ViewPagerAdapter(this, datas);
        // 绑定适配器
        vp.setAdapter(viewPagerAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    vp.setCurrentItem(datas[datas.length - 2], false);
                } else if (position == datas.length - 1) {
                    vp.setCurrentItem(1, false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        createSchdule();
    }

    private void createSchdule() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.d("tag", String.valueOf(vp.getCurrentItem() + 1));
                vp.setCurrentItem(vp.getCurrentItem() + 1, true);
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    private void initData() {
        datas[0] = Images.imageArray[Images.imageArray.length - 1];
        for (int i = 0; i < Images.imageArray.length; i++) {
            datas[i + 1] = Images.imageArray[i];
        }
        datas[datas.length - 1] = Images.imageArray[0];
    }
}