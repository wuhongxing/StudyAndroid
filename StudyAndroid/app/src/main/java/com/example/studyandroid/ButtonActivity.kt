package com.example.studyandroid

import android.location.GnssAntennaInfo
import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class ButtonActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        button.setOnClickListener {
            println(it)
        }

        button.setOnClickListener(View.OnClickListener {
            println(it)
        })

        button.setOnClickListener(this)

        button.setOnClickListener(Li())
    }

    class Li: View.OnClickListener {
        override fun onClick(p0: View?) {
            println(p0)
        }
    }

    override fun onClick(p0: View?) {
        println(p0)
    }

    fun myOnclick(p0: View?) {

    }
}