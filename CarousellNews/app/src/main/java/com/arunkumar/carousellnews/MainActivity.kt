package com.arunkumar.carousellnews

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arunkumar.carousellnews.api.ArticlesApiService
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var articlesApiService: ArticlesApiService
    @Inject
    lateinit var viewModel: ArticleViewModel
    @Inject
    lateinit var disposables: CompositeDisposable
    @Inject
    lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MainApp).component.inject(this)

        initializeRecyclerView()

        disposables.add(listenToArticlesList())
        disposables.add(listenToShowProgress())
        disposables.add(listenToHideProgress())
        disposables.add(listenToShowError())

        viewModel.fetchArticles()
    }

    private fun initializeRecyclerView() {
        rv_news.setHasFixedSize(true)
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = articleAdapter
    }

    private fun listenToArticlesList(): Disposable =
        viewModel
            .updateArticleList()
            .subscribe(
                {
                    articleAdapter.articleList(it.toMutableList())
                },
                {
                    showErrorUI()
                }
            )

    private fun listenToShowProgress(): Disposable =
        viewModel
            .showProgress()
            .subscribe(
                {
                    showProgressUI()
                },
                {
                    showErrorUI()
                }
            )

    private fun listenToHideProgress(): Disposable =
        viewModel
            .hideProgress()
            .subscribe(
                {
                    hideProgressUI()
                },
                {
                    showErrorUI()
                }
            )

    private fun listenToShowError(): Disposable =
        viewModel
            .showError()
            .subscribe(
                {
                    showErrorUI()
                },
                {
                    showErrorUI()
                }
            )

    private fun showProgressUI() {
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        iv_progress.startAnimation(animation)
        iv_progress.visibility = View.VISIBLE
    }

    private fun hideProgressUI() {
        iv_progress.clearAnimation()
        iv_progress.visibility = View.GONE
    }

    private fun showErrorUI() {
        hideProgressUI()
        var errorMsg = Snackbar.make(
            main_layout,
            getString(R.string.error_message),
            Snackbar.LENGTH_INDEFINITE
        )
        errorMsg.setAction("Dismiss") {
            errorMsg.dismiss()
        }.show()
    }
}
