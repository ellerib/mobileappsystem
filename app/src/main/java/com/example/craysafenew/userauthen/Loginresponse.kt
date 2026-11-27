package com.example.craysafenew.userauthen

class Loginresponse{

    data class logindata(
        val token: String? = null,
        val user: User? = null
    ): Loginresponse()


}
data class loginrequests(
    val success: Boolean,
    val message: String
)

