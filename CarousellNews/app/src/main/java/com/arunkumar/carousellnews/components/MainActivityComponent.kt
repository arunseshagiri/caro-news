package com.arunkumar.carousellnews.components

import com.arunkumar.carousellnews.MainActivity
import com.arunkumar.carousellnews.modules.ArticlesModule
import dagger.Component

@Component(modules = [ArticlesModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}