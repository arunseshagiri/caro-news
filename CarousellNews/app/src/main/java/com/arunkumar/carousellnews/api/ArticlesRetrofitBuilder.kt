package com.arunkumar.carousellnews.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ArticlesRetrofitBuilder {
    private val baseUrl: String =
        "https://storage.googleapis.com/carousell-interview-assets/android/"

    private fun gson(): Gson = GsonBuilder().setPrettyPrinting().create()

    private fun okHttpClient(): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(buildLogger())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .build()

    private fun getClient(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient())
        .build()


    private fun buildLogger(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun getApi(): ArticlesApi = getClient().create(ArticlesApi::class.java)
}