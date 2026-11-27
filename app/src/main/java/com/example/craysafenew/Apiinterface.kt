package com.example.craysafenew

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import com.example.craysafenew.userauthen.loginresponses.logindata

interface Apiinterface {

    @POST("api/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): logindata

    @POST("api/register")
    fun register(
        @Body request: registerrequests
    ): Call<ResponseApi>

    @GET("api/alerts")
    fun getalerts(
        @Body request: alertnotif
    ): Call<ResponseApi>
}