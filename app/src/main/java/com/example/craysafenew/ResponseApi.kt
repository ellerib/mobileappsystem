package com.example.craysafenew

data class ResponseApi (
    val success: Boolean,
    val message: String
)

// LOGIN DATA HOLDER

//REGISTER DATA HOLDER
data class registerrequests(
    val username: String,
    val password: String,
    val productid: String,
    val email: String
)

// ALERT DATA HOLDER
data class alertnotif(
    val alertdate: String,
    val severity: String,
    val parameter: String, // PH, TEMP, TURBIDITY
    val description: String,
    val suggestion:String,
    val advice: String, // SAME AS SUGGESTION
    val message: String,
    val status: String,
    val tankname: String
)

data class alertresponse(
    val success: Boolean,
    val data: List<alertnotif>?=null,
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


