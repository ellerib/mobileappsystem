package com.example.craysafenew

data class ResponseApi (
    val success: Boolean,
    val message: String
)

data class loginrequests(
    val email: String,
    val password: String
)

data class registerrequests(
    val username: String,
    val password: String,
    val productid: String,
    val email: String
)

// ALERT RESPONSE
data class alertrequests(
    val alertdate: String,
    val severity: String,
    val parameter: String, // PH, TEMP, TURBIDITY
    val description: String,
    val advice: String,
    val message: String,
    val status: String,
    val tank_name: String
)

data class alertresponse(
    val success: Boolean,
    val data: List<alertrequests>?=null,
    val unreadcount: Int? = null,
    val message: String? = null
)

data class markresponse(
    val success: Boolean,
    val message: String
)



    //FOR REGISTER RESPONSE

//    // FOR LOGIN RESPONSE
//    fun login(){
//        val username: String;
//        val password: String;
//    }


