package com.example.firstlineofandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        final TextView textview = (TextView)findViewById(R.id.edit_text);
        textview.setText(bundle.getSerializable("text").toString());
        final String text = textview.getText().toString();
        findViewById(R.id.ensure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("text", textview.getText().toString());
                setResult(0x11, intent);
                finish();
            }
        });
    }

    public static void actionStart(Activity activity, String text) {
        Intent intent = new Intent(activity, FirstActivity.class);
        intent.putExtra("text", text);
        activity.startActivityForResult(intent, 0x11);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show();
                break;
            default: break;
        }
        return true;
    }
}
