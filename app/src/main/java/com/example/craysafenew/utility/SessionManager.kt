package com.example.craysafenew.utility

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val preference: SharedPreferences = context.getSharedPreferences("craysafepreference",
        Context.MODE_PRIVATE)

    companion object{
        private const val KEY_TOKEN = "authtoken"
        private const val KEYISLOGGEDIN = "isloggedin"
        private const val KEYUSERID = "userid"
        private const val KEYUSERNAME = "username"
        private const val KEYUSEREMAIL = "useremail"
        private const val KEYSELECTEDTANKID = "selectedtankid"

    }

    // AUTHENTICATION WHEN USER LOGGED IN
    fun Saveuthen(token: String, Userid: Int, username: String, email: String){
        preference.edit().apply{
            putString(KEY_TOKEN, token)
            putBoolean(KEYISLOGGEDIN, true)
            putInt(KEYUSERID, Userid)
            putString(KEYUSERNAME, username)
            putString(KEYUSEREMAIL, email)
            apply()

        }

    }

    fun gettoken():String? = preference.getString(KEY_TOKEN, null)
    fun getuserid(): Int = preference.getInt(KEYUSERID, 0)
    fun getusername():String? = preference.getString(KEYUSERNAME, null)
    fun getuseremail(): String? = preference.getString(KEYUSEREMAIL, null)
    fun getloggedinstatus(): Boolean = preference.getBoolean(KEYISLOGGEDIN, false)

    fun setselectedtankid(tankdid: Int){
        return preference.edit().putInt(KEYSELECTEDTANKID, tankdid).apply()
    }

    fun getselectedtankid(): Int{
        return preference.getInt(KEYSELECTEDTANKID, -1)
    }

    fun userlogout(){
        preference.edit().clear().apply()
    }

}