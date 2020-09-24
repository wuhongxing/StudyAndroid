package com.example.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        myViewModel.getLikedNumber().observe(this, object : Observer<Int> {
            override fun onChanged(t: Int?) {
                text_view.setText("$t")
            }
        })
        button1.setOnClickListener {
            myViewModel.addLikedNumber(1)
        }
        button2.setOnClickListener {
            myViewModel.addLikedNumber(-1)
            val intent = Intent()
            intent.setClass(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}