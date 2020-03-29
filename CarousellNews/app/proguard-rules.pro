#---------- Gson start ----------
# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

#---------- Gson end ----------

# for prettytime
-keep class com.ocpsoft.pretty.time.i18n.**
-keep class org.ocpsoft.prettytime.i18n.**
-keepnames class ** implements org.ocpsoft.prettytime.TimeUnit

-keep class com.arunkumar.carousellnews.model.** { *; }
-keepnames class com.arunkumar.carousellnews.model.** { *; }