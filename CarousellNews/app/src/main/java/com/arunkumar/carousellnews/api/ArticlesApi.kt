package com.arunkumar.carousellnews.api

import com.arunkumar.carousellnews.model.Articles
import io.reactivex.Single
import retrofit2.http.GET

interface ArticlesApi {
    @GET("carousell_news.json")
    fun articles(): Single<List<Articles>>
}