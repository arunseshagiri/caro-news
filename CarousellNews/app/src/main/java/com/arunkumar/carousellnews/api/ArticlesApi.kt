package com.arunkumar.carousellnews.api

import com.arunkumar.carousellnews.model.Articles
import com.arunkumar.carousellnews.model.OuterArticle
import io.reactivex.Single
import retrofit2.http.GET

interface ArticlesApi {
    @GET("news_1.json")
    fun articles(): Single<OuterArticle>
}