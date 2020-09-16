package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
//    lateinit var mBinding: ActivityMainBinding
//    lateinit var mViewModel: ViewModel

    lateinit var mBinding: ActivityMainBinding
    lateinit var mViewModel: PaoViewModel

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val remote = Retrofit.Builder()
            .baseUrl("http://api.jcodecraeer.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PaoService::class.java)
        mViewModel = PaoViewModel(remote)
        mBinding.vm = mViewModel

//        setContentView(R.layout.activity_main)

//        var animal = Animal("dog", 0)
//        textView.text = "${animal.name} 叫了 ${animal.shoutCount} 声..."
//        button.setOnClickListener {
//            animal.shoutCount ++
//            textView.text  = "${animal.name} 叫了 ${animal.shoutCount} 声..."
//        }

//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val animal = Animal("dog", 0)
//        mViewModel = ViewModel(animal, this)
//        mBinding.vm = mViewModel
    }
}

data class Animal(val name: String, var shoutCount: Int)

class ViewModel(val animal: Animal, context: MainActivity) {
    val info = ObservableField<String>("${animal.name} 叫了 ${animal.shoutCount} 声...")

    fun shout(view: View) {
        animal.shoutCount ++
        info.set("${animal.name} 叫了 ${animal.shoutCount} 声...")
    }

    fun load(view: View) {

    }
}


// 服务
interface PaoService {
    @GET("article_detail.php")
    fun getArticleDetail(@Query("id") id: Int): Single<Article>
}

// 模型
class Article {

}

// vm
class PaoViewModel(val remote: PaoService) {
    val articleDetail = ObservableField<String>()

    fun loadArticle() {
        remote.getArticleDetail(8773)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t: Article? ->
                articleDetail.set(t?.toString())
            }, { t: Throwable? ->
                articleDetail.set(t?.message ?: "error")
            })
    }
}
