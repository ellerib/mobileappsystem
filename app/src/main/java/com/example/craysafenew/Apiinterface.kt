package com.example.craysafenew

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Apiinterface {

    @POST("api/login")
    fun login(
        @Body request: loginrequests
    ): Call<ResponseApi>

    @POST("api/register")
    fun register(
        @Body request: registerrequests
    ): Call<ResponseApi>

    fun getallalerts(
        request: alertrequests
    ): Call<ResponseApi>
}