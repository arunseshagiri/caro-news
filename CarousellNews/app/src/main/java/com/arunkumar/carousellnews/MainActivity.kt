package com.arunkumar.carousellnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arunkumar.carousellnews.api.ArticlesApiService
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var articlesApiService: ArticlesApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (applicationContext as MainApp).component.inject(this)

        articlesApiService
            .articles()
            .observeOn(mainThread())
            .subscribe(
                {
                    Timber.d("${it[0].timeCreated}")
                },
                {
                    it.printStackTrace()
                }
            )
    }
}
