package com.example.craysafenew

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

object ApiBuilder {
    // RETROFIT BUILDER
    private const val urllink = "http://192.168.1.1:8000/"

    //OKHTTP BUILDER
    private val client = OkHttpClient.Builder()
        .build()

    // BUILDER
    val apiinterface:  Apiinterface by lazy{
        Retrofit.Builder()
            .baseUrl(urllink)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(apiinterface::class.java)
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
