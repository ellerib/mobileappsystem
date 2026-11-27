package com.example.craysafenew

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Cache
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.create
import java.io.File
import java.util.concurrent.TimeUnit

object ApiBuilder {
    // RETROFIT BUILDER
    private const val urllink = "http://192.168.1.1:8000/" //BASE URL DESTINATION
    private var retrofit: Retrofit? = null

    fun init(context: Context){
        if (retrofit!=null)
            return

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // CREATING CACHE
        val cache = Cache(
            File(context.cacheDir, "http_cache"),
            10L * 1024 * 1024
        )

        // BUILD OKHTTP CLIENT WITH TOMEOUTS AND ACHE
        val client = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request()
                val newrequests = request.newBuilder()
                    .header("Cache-Control", "public, max-age=60")
                    .build()
                chain.proceed(newrequests)
            }

            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(urllink)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val Apiinterface: ApiBuilder by lazy{
        retrofit!!.create(Apiinterface::class.java)
    }

}

//    // REQUEST BUILDER
//    fun getrequests(url: String, callback: Callback): Call{
//        val request = Request.Builder()
//            .url(urllink)
//            .build()
//
//        val call = client.newCall(request)
//        call.enqueue(callback)
//
//        return call
//    }
//
//    fun postrequests(url: String, responseApi: ResponseApi, callback: Callback): Call{
//
//        val request = Request.Builder()
//            .url(urllink)
//            .build()
//
//        val call = client.newCall(request)
//        call.enqueue(callback)
//
//        return call
//    }
