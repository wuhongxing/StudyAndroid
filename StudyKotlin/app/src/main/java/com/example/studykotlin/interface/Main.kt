package com.example.javabase.`interface`

import android.util.Log
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.properties.Delegates

fun main(args: Array<String>) {
//    lateinit var name: String
//    name = "1"
//    val name1: String by lazy { println("123-"); "123" }
//    val label: String by lazy {
//        val label = ""
//        label
//    }

//    var title: String by Delegates.observable("title_default") {
//
//    }

//    var price: Int by Delegates.vetoable(100, { property, oldValue, newValue ->
//        if (newValue > 100) {
//            Log.d("AAA", "属性变化：属性名：$property  旧值：$newValue > 100 不符合需求不能更改数据")
//            false
//        }
//        return@vetoable true
//    })

//    var son = BigHeadSon()
//    son.washing()
//
//    var father = SmallHeadFather()
//    father.washing()
//
//    println(name)
//    println(name1)
//    println(name1)

//    var test: String? = null
//    test?.let {
//        println(it)
//        return@let "123"
//    }
//    with(test) {
//        println(test?.length)
//    }

    val original = "abc"
// 改变值并且传递到下一链条
    original.let {
        println("The original String is $it") // "abc"
        it.reversed() // 改变参数并且传递到下一链条
    }.let {
        println("The reverse String is $it") // "cba"
        it.length   // 改变类型
    }.let {
        println("The length of the String is $it") // 3
    }

//    name.hehe()
//
//    name.afterMersure {
//        this.reversed()
//    }
//    println(name)
//
//    name.afterMersure1 {
//        name.reversed()
//    }
//
//    println(name)
}

fun <T: String>T.afterMersure(f: T.() -> Unit) {
    f()
}

fun <T: String>T.afterMersure1(f: () -> Unit) {
    f()
}


private fun String.hehe() {
    println(this + "hehe")
}
