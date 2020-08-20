package com.example.studyjavabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        final Button buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setTag(5);
        final TextView textView = (TextView)findViewById(R.id.textView);

        final Button button1 = (Button) findViewById(R.id.buttonOne);
        button1.setTag(1);
        final Button button2 = (Button) findViewById(R.id.buttonTwo);
        button2.setTag(2);
        final Button button3 = (Button) findViewById(R.id.buttonThree);
        button3.setTag(3);
        final Button button4 = (Button) findViewById(R.id.buttonFour);
        button4.setTag(4);
        listener listener = new listener();
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        buttonClear.setOnClickListener(listener);
    }

    class listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView textView = (TextView)findViewById(R.id.textView);
            String text = textView.getText().toString();
            int i = 0;
            switch ((int)view.getTag()) {
                case 1:
                    i = Integer.valueOf(text).intValue() + 1;
                    break;
                case 2:
                    i = Integer.valueOf(text).intValue() + 10;
                    break;
                case 3:
                    i = Integer.valueOf(text).intValue() - 1;
                    break;
                case 4:
                    i = Integer.valueOf(text).intValue() - 10;
                    break;
                case 5:
                    i = 0;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getTag());
            }
            textView.setText(String.valueOf(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}