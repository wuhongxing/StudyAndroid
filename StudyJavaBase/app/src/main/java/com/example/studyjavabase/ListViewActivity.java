package com.example.studyjavabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.javabase.Animal;
import com.example.javabase.AnimalAdapter;

import java.util.LinkedList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Context context = ListViewActivity.this;
        ListView listView = (ListView)findViewById(R.id.listView);
        LinkedList<Animal> mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你是狗么?", 0, false));
        mData.add(new Animal("牛说", "你是牛么?", 1, false));
        mData.add(new Animal("鸭说", "你是鸭么?", 2, true));
        mData.add(new Animal("鱼说", "你是鱼么?", 3, true));
        mData.add(new Animal("狗说", "你是狗么?", 0, true));
        mData.add(new Animal("牛说", "你是牛么?", 1, true));
        mData.add(new Animal("鸭说", "你是鸭么?", 2, true));
        mData.add(new Animal("鱼说", "你是鱼么?", 3, true));
        mData.add(new Animal("狗说", "你是狗么?", 0, true));
        mData.add(new Animal("牛说", "你是牛么?", 1, true));
        mData.add(new Animal("鸭说", "你是鸭么?", 2, true));
        mData.add(new Animal("鱼说", "你是鱼么?", 3, true));
        AnimalAdapter adapter = new AnimalAdapter((LinkedList<Animal>)mData, context);
        listView.setAdapter(adapter);
    }
}