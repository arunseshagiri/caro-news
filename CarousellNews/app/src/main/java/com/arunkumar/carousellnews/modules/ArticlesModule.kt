package com.arunkumar.carousellnews.modules

import com.arunkumar.carousellnews.api.ArticlesApiService
import com.arunkumar.carousellnews.api.ArticlesRetrofitBuilder
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {

    @Provides
    fun retrofitBuilder(): ArticlesRetrofitBuilder = ArticlesRetrofitBuilder()

    @Provides
    fun articleApiService(retrofitBuilder: ArticlesRetrofitBuilder): ArticlesApiService =
        ArticlesApiService(retrofitBuilder)
}