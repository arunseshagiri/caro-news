package com.arunkumar.carousellnews.modules

import com.arunkumar.carousellnews.ArticleAdapter
import com.arunkumar.carousellnews.ArticleViewModel
import com.arunkumar.carousellnews.api.ArticlesApiService
import com.arunkumar.carousellnews.api.ArticlesRetrofitBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ArticlesModule {

    @Provides
    fun retrofitBuilder(): ArticlesRetrofitBuilder = ArticlesRetrofitBuilder()

    @Provides
    fun articleApiService(retrofitBuilder: ArticlesRetrofitBuilder): ArticlesApiService =
        ArticlesApiService(retrofitBuilder)

    @Provides
    fun provideArticleViewModel(articlesApiService: ArticlesApiService): ArticleViewModel =
        ArticleViewModel(articlesApiService)

    @Provides
    fun provideArticleAdapter(): ArticleAdapter = ArticleAdapter(mutableListOf())

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}