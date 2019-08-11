package com.arunkumar.carousellnews.api

import com.arunkumar.carousellnews.model.Articles
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io

class ArticlesApiService(private val retrofitBuilder: ArticlesRetrofitBuilder) {
    fun articles(): Single<List<Articles>> = retrofitBuilder.getApi().articles().subscribeOn(io())
}