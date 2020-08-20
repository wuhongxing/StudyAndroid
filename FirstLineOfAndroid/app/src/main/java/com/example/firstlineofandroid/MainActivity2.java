package com.example.firstlineofandroid;

import android.app.Activity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    // 图片地址
    private final String PATH = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000" +
            "&sec=1544714792699&di=3c2de372608ed6323f583f1c1b445e51&imgtype=0&src=http%3A%2F%2Fp" +
            "2.qhimgs4.com%2Ft0105d27180a686e91f.jpg";

    // 成功标识
    private final int SUCCESS = 200;

    // 失败标识
    private final int ERROR = 404;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.iv_image);
    }

    /**
     * 定义Handler，用于接收子线程发过来的信息
     */
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    imageView.setImageBitmap((Bitmap) msg.obj);
                    break;
                case ERROR:
                    Toast.makeText(MainActivity2.this, "下载失败,请检查原因", Toast.LENGTH_LONG).show();
                    break;
            }

            if (null != progressDialog)
                progressDialog.dismiss();
        }
    };

    private ProgressDialog progressDialog = null;

    /**
     * 获取图片 按钮
     * @param view
     */
    public void getImage(View view) {
        progressDialog = new ProgressDialog(MainActivity2.this);
        progressDialog.setMessage("正在下载...");
        progressDialog.show();

        // 开启子线程 下载图片
        /**
         * 执行此方法才去启动线程下载
         */
        new Thread(new DownloadImage()).start();
    }

    class DownloadImage implements Runnable {

        /**
         * 发送Handler
         */
        public void showUiImage(int responseCode, Bitmap bitmap) {
            Message message = mHandler.obtainMessage(responseCode); // 拿系统消息池的消息, 不要 new Message();
            message.obj = bitmap;
            mHandler.sendMessageDelayed(message, 2000);
        }

        @Override
        public void run() {
            try {
                // 封装成网络地址
                URL url = new URL(PATH);

                // 打开一个连接
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                // 设置连接时长
                httpURLConnection.setConnectTimeout(5000);

                // 设置请求方式
                httpURLConnection.setRequestMethod("GET");

                /**
                 * 注意：⚠️ 不要肤浅的任务 打开连接对象 设置连接时长 设置请求方式 就向服务器发送Http请求了
                 *          是要执行httpURLConnection.getResponseCode()才会向服务器发送Http请求
                 */
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    // 得到服务器返回过来的流对象
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    showUiImage(SUCCESS, bitmap);
                } else {
                    showUiImage(ERROR, null);
                }

            } catch (Exception e) {
                e.printStackTrace();
                showUiImage(ERROR, null);
            }
        }
    }
}