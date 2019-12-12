package com.arunkumar.carousellnews.api

import com.arunkumar.carousellnews.jsonpconverter.Jsonp
import com.arunkumar.carousellnews.model.OuterArticle
import io.reactivex.Single
import retrofit2.http.GET

interface ArticlesApi {
    @GET("news_1.json")
    @Jsonp
    fun articles(): Single<OuterArticle>
}