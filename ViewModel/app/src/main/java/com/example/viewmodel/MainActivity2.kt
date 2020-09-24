package com.example.viewmodel

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.example.viewmodel.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), ScoreViewModelCallback {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        //        binding.setVariable(BR.vm, ScoreViewModel())
        val viewModel = ScoreViewModel()
        viewModel.delegate = this
        binding.vm = viewModel

    }

    override fun buttonDidClicked() {
        print("回调到控制器中了")
    }
}