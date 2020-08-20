package com.example.javabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyjavabase.R;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class AnimalAdapter extends BaseAdapter {
    private LinkedList<Animal> _data;
    private Context _context;

    public AnimalAdapter(LinkedList<Animal> data, Context context) {
        _data = data;
        _context = context;
    }

    @Override
    public int getCount() {
        return _data.size();
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
            view = LayoutInflater.from(_context).inflate(R.layout.item_list_animal, viewGroup, false);
            holder = new ViewHolder();
            holder.icon = (ImageView)view.findViewById(R.id.icon);
            holder.title = (TextView)view.findViewById(R.id.title);
            holder.detail = (TextView)view.findViewById(R.id.detailTitle);
            holder.check = (CheckBox)view.findViewById(R.id.check);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
//        icon.setBackgroundResource(_data.get(i).get_icon());
        holder.title.setText(_data.get(i).get_name());
        holder.detail.setText(_data.get(i).get_speak());
        holder.check.setChecked(_data.get(i).is_check());
        return view;
    }

    static class ViewHolder {
        ImageView icon;
        TextView title;
        TextView detail;
        CheckBox check;
    }
}

