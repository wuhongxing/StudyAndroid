package com.example.firstlineofandroid;

import android.util.Log;

import java.io.IOException;

public class SaleTicket implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0 ) {
                    Log.d("Tag", Thread.currentThread().getName()+"卖出了第"+(20-ticket+1)+"张票");
                    ticket -= 1;
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
