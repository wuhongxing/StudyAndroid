package com.example.javabase.`interface`

import android.util.Log
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.properties.Delegates

class Calculator() {
    var a: Int = 0
    var b: Int = 0
    fun add() = a + b
    fun multiply() = a * b
}

fun main() {
//    var a: String? = null
//
//    var number = 1
//    run { number ++ }.run { number++ }
//    println(number)

    println((0 until 2).random())

//    var calculator = Calculator()
//    doCalculation(calculator)
}

fun doCalculation(calculator: Calculator) {
//    val result =  calculator.run {
//        a = 10
//        b = 20
//        add()
//    }
//    println(result)

    with(calculator) {
        a = 10
        b = 20
    }

    println(calculator.add())
}

fun large(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

fun large1(num1: Int, num2: Int) = if (num1 > num2) num1 else num2