package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 *
 */
public class RecyclerView extends ViewGroup {
    private boolean needRelayout;
    private List<View> viewList;

    public RecyclerView(Context context) {
        super(context);

    }

    public RecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public RecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        if (needRelayout || b) {
            needRelayout = false;
            viewList.clear();
            removeAllViews();

        }
    }

    public void setAdapter(Adapter adapter) {
        needRelayout = true;
    }

    interface Adapter {
        View OnCreateViewHolder();
    }

}
