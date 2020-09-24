package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson1.object.DaggerMyComponent;
import com.example.lesson1.object.DatabaseModule;
import com.example.lesson1.object.DatabaseObject;
import com.example.lesson1.object.HttpModule;
import com.example.lesson1.object.HttpObject;

import org.w3c.dom.Text;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    HttpObject httpObject;

    @Inject
    DatabaseObject databaseObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMyComponent.create().inject(this);
        DaggerMyComponent.builder().httpModule(new HttpModule()).databaseModule(new DatabaseModule()).build().inject(this);
        System.out.println(httpObject.toString());
    }

    private void getImage() {

    }

}