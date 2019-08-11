package com.arunkumar.carousellnews

import androidx.multidex.MultiDexApplication
import timber.log.Timber

class MainApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}