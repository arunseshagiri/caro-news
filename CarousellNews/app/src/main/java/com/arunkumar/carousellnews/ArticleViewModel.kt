package com.arunkumar.carousellnews

import com.arunkumar.carousellnews.api.ArticlesApiService
import com.arunkumar.carousellnews.model.Articles
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.subjects.PublishSubject

class ArticleViewModel(private val articlesApiService: ArticlesApiService) {
    private var updateArticleList: PublishSubject<List<Articles>> = PublishSubject.create()
    private var showProgress: PublishSubject<Unit> = PublishSubject.create()
    private var hideProgress: PublishSubject<Unit> = PublishSubject.create()
    private var showError: PublishSubject<String> = PublishSubject.create()

    fun updateArticleList(): PublishSubject<List<Articles>> = updateArticleList

    fun showProgress(): PublishSubject<Unit> = showProgress

    fun hideProgress(): PublishSubject<Unit> = hideProgress

    fun showError(): PublishSubject<String> = showError

    fun fetchArticles() = articlesApiService
        .articles()
        .observeOn(mainThread())
        .doOnEvent { _, _ -> hideProgress().onNext(Unit) }
        .doOnSubscribe { showProgress().onNext(Unit) }
        .subscribe(
            {
                updateArticleList().onNext(it)
            },
            { showError().onNext(it.message!!) }
        )


}