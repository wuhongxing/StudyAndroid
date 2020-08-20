package com.example.firstlineofandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView textview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView)findViewById(R.id.edit_text);

        textview.setText(load());
        findViewById(R.id.ensure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                push();
//                home();
//                baidu();
//                implicitIntent();
//                actionPush();
//                loadPreferences();
//                testThread();
//                testRunnable();
//                saleTicket();
//                testCache();
//                testFixed();
//                testSingle();
//                testScheduled();
//                setTitle();
//                setTitle1();
                new TestTask().execute();
            }
        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        findViewById(R.id.shared_preferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePreferences();
            }
        });
        findViewById(R.id.get_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.cycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    class TestTask extends AsyncTask<Void, Void, String> {
        // 在异步线程里面执行
        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "123456";
        }
        // 切换到主线程里面执行
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textview.setText(s);
        }
    }

    private Handler handler = new Handler() {
        // 接受消息等待处理
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            textview.setText("123456789");
        }
    };

    private void setTitle1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(1);
            }
        }).start();
    }

    private void setTitle() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 在非 UI 线程里面更新 UI 控件
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textview.setText("123456789");
                    }
                });
            }
        }).start();
    }

    private void testFixed() {
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(3);
        final int index = 0;
        for (int i = 0; i < 10; i++) {
            fixThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("Tag", Thread.currentThread().getName() + " " + index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void testSingle() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = 0;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("Tag", Thread.currentThread().getName() + " " + index);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void testScheduled() {
        Log.d("Tag", "begin");
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("Tag", "delay 3 seconds");
//            }
//        }, 3, TimeUnit.SECONDS);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.d("Tag", "delay 3 seconds");
            }
        }, 2, 3, TimeUnit.SECONDS);
    }

    private void testCache() {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        final int index = 0;
        for (int i = 0; i < 10; i++) {
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("Tag", Thread.currentThread().getName() + " " + index);
                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void testThread() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    private void testRunnable() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    private void saleTicket() {
        SaleTicket saleTicket = new SaleTicket();
        Thread thread1 = new Thread(saleTicket, "A代理");
        Thread thread2 = new Thread(saleTicket, "B代理");
        Thread thread3 = new Thread(saleTicket, "C代理");
        Thread thread4 = new Thread(saleTicket, "D代理");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private void savePreferences() {
        String text = textview.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("name", "Tom");
        editor.putInt("age", 28);
        editor.putBoolean("married", false);
        editor.apply();
    }

    private void loadPreferences() {
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        String name = preferences.getString("name", "");
        int age = preferences.getInt("age", 0);
        boolean married = preferences.getBoolean("married", false);
        Log.d("MainActivity", "name is" + name);
        Log.d("MainActivity", "age is" + age);
        Log.d("MainActivity", "married is" + married);
    }

    private String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data.txt");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    private void save() {
        String data = textview.getText().toString();
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data.txt", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void push() {
        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
        Bundle bundle = new Bundle();
        final String text = textview.getText().toString();
        bundle.putString("text", text);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0x11);
    }

    private void actionPush() {
        FirstActivity.actionStart(MainActivity.this, textview.getText().toString());
    }

    private void home() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    private void baidu() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.baidu.com"));
        startActivity(intent);
    }

    private void implicitIntent() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x11 && resultCode == 0x11) {
            textview.setText(data.getStringExtra("text"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show();
                break;
            default: break;
        }
        return true;
    }
}