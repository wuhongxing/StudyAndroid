package com.example.firstlineofandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

public class BitMapTask extends AsyncTask<Integer, Void, Bitmap> {
    private Context context;
    private int res;
    private ImageView imageView;

    public BitMapTask(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(Integer... ints) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        res = ints[0];
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res);
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
