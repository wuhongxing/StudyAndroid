package com.example.lesson2;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslCertificate;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class ComposeView extends LinearLayout implements View.OnClickListener {
    private Button buttonMinus;
    private Button buttonAdd;
    private TextView textView;

    public ComposeView(Context context) {
        this(context, null);
    }

    public ComposeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComposeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        // 这一句其实就是将 R.layout.layout_compose 这个布局加到 this 上了
        // 和 iOS 中的 loadMainBundle 中的 view 加到 self 上是一样的
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout_compose, this);
        buttonMinus = (Button)linearLayout.findViewById(R.id.button_minus);
        buttonAdd = (Button)linearLayout.findViewById(R.id.button_add);
        textView = (TextView)linearLayout.findViewById(R.id.text_view);

        // 这种写法感觉和代理非常像
        // iOS 如果我没有记错，应该是和命令模式一样
        buttonAdd.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (textView.getText().toString() == "0") {
                    textView.setText(charSequence.toString());
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

//                if (textView.getText().toString().equals("0")) {
//
//                    textView.setText(charSequence.subSequence(1, 2).toString());
//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        String text = textView.getText().toString();
        Integer number = new Integer(text);
        switch (view.getId()) {
            case R.id.button_minus:
                textView.setText(String.valueOf(number - 1));
                if (number == 1) {
                    buttonMinus.setEnabled(false);
                }
                break;
            case R.id.button_add:
                textView.setText(String.valueOf(number + 1));
                buttonMinus.setEnabled(true);
                break;
        }
    }
}
