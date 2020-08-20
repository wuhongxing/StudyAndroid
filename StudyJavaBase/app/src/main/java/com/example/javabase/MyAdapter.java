package com.example.javabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyjavabase.R;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private LinkedList<Data> data;

    public MyAdapter(LinkedList<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_animal, viewGroup, false);
            holder = new ViewHolder();
            holder.content = (TextView)view.findViewById(R.id.title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.content.setText(data.get(i).getContent());
        return view;
    }

    public void add(Data data) {
        if (this.data == null) {
            this.data = new LinkedList<>();
        }
        this.data.add(data);
        notifyDataSetChanged();
    }

    public void remove() {
        if (this.data.getLast() != null) {
            this.data.removeLast();
        }
        notifyDataSetChanged();
    }

    public void clear(Data data) {
        this.data.remove();
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView content;
    }
}
