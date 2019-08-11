package com.arunkumar.carousellnews.adapters

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.ocpsoft.prettytime.PrettyTime
import timber.log.Timber
import java.lang.reflect.Type
import java.sql.Timestamp
import java.util.*

class TimestampToPrettyTime : JsonDeserializer<String> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): String {
        Timber.d("time_created: %s", json?.asLong)
        val timestamp = Timestamp(json?.asLong ?: 0)
        val date: Date? = Date(timestamp.time)
        val prettyTime = PrettyTime()
        return prettyTime.format(date)
    }

}