package com.example.firstlineofandroid;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int[] datas;

    public ViewPagerAdapter(Context context, int[] datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    // 用于渲染每一页的数据
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View layout = layoutInflater.inflate(R.layout.viewpage_item, null);
        ImageView imageView = (ImageView)layout.findViewById(R.id.item_iv);
        imageView.setImageResource(R.drawable.placeholder);
//        imageView.setImageResource(datas[position]);
        // 添加到 ViewPager 里面去
        BitMapTask bitMapTask = new BitMapTask(context, imageView);
        bitMapTask.execute(datas[position]);
        container.addView(layout);
        return layout;
    }
}
