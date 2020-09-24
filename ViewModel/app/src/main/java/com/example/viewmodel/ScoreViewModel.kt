package com.example.viewmodel

import android.view.View
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ScoreBean(var redScore: Int, var blueScore: Int)

class ScoreViewModel: BaseObservable() {
    var redScore: Int = 0
    var blueScore: Int = 0
    var delegate: ScoreViewModelCallback? = null
    set(value) {
        field = value
    }

    fun click(view: View) {
        when (view.id) {
            R.id.button -> redScore += 1
            R.id.button3 -> blueScore += 1
            R.id.button4 -> redScore += 2
            R.id.button5 -> redScore += 3
            R.id.button6 -> blueScore += 2
            R.id.button7 -> blueScore += 3
            R.id.button8 -> {

            }
            R.id.button9 -> {
                redScore = 0
                blueScore = 0
            }
        }
        delegate?.buttonDidClicked()
        delegate
        notifyChange()
    }


}

interface ScoreViewModelCallback {
    fun buttonDidClicked()
}