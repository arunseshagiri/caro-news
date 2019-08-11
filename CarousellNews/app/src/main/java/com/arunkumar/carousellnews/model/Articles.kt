package com.arunkumar.carousellnews.model

import com.google.gson.annotations.SerializedName

data class Articles(
    @field:SerializedName("title") val title: String,
    @field:SerializedName("description") val description: String,
    @field:SerializedName("banner_url") val bannerUrl: String,
    @field:SerializedName("time_created") val timeCreated: Long,
    @field:SerializedName("rank") val rank: Int
)