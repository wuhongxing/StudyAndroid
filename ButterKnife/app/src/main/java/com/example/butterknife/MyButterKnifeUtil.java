package com.example.butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyButterKnifeUtil {
    private static final String TAG = "MyButtonKnifeUtil";
    public static void injectLayoutId(Activity activity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classzz = activity.getClass();
        boolean isBindLayoutID = classzz.isAnnotationPresent(BindLayoutId.class);
        if (isBindLayoutID) {
            BindLayoutId bindLayoutIdzz = (BindLayoutId)classzz.getAnnotation(BindLayoutId.class);
            int layoutId = bindLayoutIdzz.value();
            int d = Log.d(TAG, "--injectLayoutId layoutId=" + layoutId);

            Method setContentViewMethod = classzz.getMethod("setContentView", int.class);
            setContentViewMethod.invoke(activity, layoutId);
        }
    }

    public static void injectViewId(Activity activity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classzz = activity.getClass();
        Field[] fields = classzz.getDeclaredFields();
        for (Field field: fields) {
            boolean isMyBindView = field.isAnnotationPresent(MyBindView.class);
            if (!isMyBindView) {
                continue;
            }
            MyBindView myBindViewzz = field.getAnnotation(MyBindView.class);
            int myViewId = myBindViewzz.value();
            Method method = classzz.getMethod("findViewById", int.class);
            View view = (View)method.invoke(activity, myViewId);
            field.setAccessible(true);
            field.set(activity, view);
        }
    }

    public static void injectListener(Activity activity) {

    }
}
