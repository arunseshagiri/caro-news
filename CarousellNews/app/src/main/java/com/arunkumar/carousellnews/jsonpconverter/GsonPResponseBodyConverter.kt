package com.arunkumar.carousellnews.jsonpconverter

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.Reader

class GsonPResponseBodyConverter<out T>(private val gson: Gson, private val adapter: TypeAdapter<out T>) : Converter<ResponseBody, Any> {
    override fun convert(value: ResponseBody): T? {
        val reader: Reader = value.charStream()
        var item: Int = reader.read()
        while (item != '('.toInt() && item != -1) {
            item = reader.read()
        }
        val jsonReader: JsonReader = gson.newJsonReader(reader)
        return try {
            adapter.read(jsonReader)
        } finally {
            reader.close()
        }
    }

}