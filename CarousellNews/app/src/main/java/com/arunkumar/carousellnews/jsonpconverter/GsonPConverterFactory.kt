package com.arunkumar.carousellnews.jsonpconverter

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class GsonPConverterFactory(val gson: Gson) : Converter.Factory() {

    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        for (annotation in annotations) {
            if (annotation.annotationClass == Json::class) {
                return GsonConverterFactory.create(gson).responseBodyConverter(type, annotations, retrofit)
            }
        }

        val adapter: TypeAdapter<*> = gson.getAdapter(TypeToken.get(type))
        return GsonPResponseBodyConverter<Any>(gson, adapter)
    }

}