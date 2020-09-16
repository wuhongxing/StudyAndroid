package com.example.butterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;

@BindLayoutId(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @MyBindView(R.id.button1)
    Button button1;
    @MyBindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            MyButterKnifeUtil.injectLayoutId(this);
            MyButterKnifeUtil.injectViewId(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        button1.setText("button1 - mybindview");
        button2.setText("button2 - mybindview");
    }
}