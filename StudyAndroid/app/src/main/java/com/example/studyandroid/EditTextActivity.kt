package com.example.studyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        edit_text.setOnFocusChangeListener { view, b ->
            if (b) {
                println("获取焦点")
            } else {
                println("失去焦点")
            }
        }

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println(p0)
                println(p1)
                println(p2)
                println(p3)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println(p0)
                println(p1)
                println(p2)
                println(p3)
            }

            override fun afterTextChanged(p0: Editable?) {
                println(p0)
            }
        })
    }
}