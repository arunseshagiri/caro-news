package com.arunkumar.carousellnews.model

import com.google.gson.annotations.SerializedName

data class OuterArticle(@SerializedName("products") val products: Map<String, Articles>)
