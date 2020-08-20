package com.example.studyjavabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.javabase.Data;
import com.example.javabase.MyAdapter;

import java.util.LinkedList;
import java.util.List;

public class RefreshListViewActivity extends AppCompatActivity {

    private LinkedList<Data> data = new LinkedList<Data>();
    private MyAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter((LinkedList<Data>)data, RefreshListViewActivity.this);
        listView.setAdapter(adapter);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(new Data("数据" + data.size()));
            }

        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove();
            }
        });
    }
}