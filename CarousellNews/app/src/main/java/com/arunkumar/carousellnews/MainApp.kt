package com.arunkumar.carousellnews

import androidx.multidex.MultiDexApplication
import com.arunkumar.carousellnews.components.DaggerMainActivityComponent
import com.arunkumar.carousellnews.components.MainActivityComponent
import timber.log.Timber

class MainApp : MultiDexApplication() {

    lateinit var component: MainActivityComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        component = DaggerMainActivityComponent.builder().build()
    }

}