package com.example.craysafenew.userauthen

import android.os.Bundle
import com.example.craysafenew.ApiBuilder
import com.example.craysafenew.menus.Dashboardfragment
import com.example.craysafenew.userauthen.LoginAuth
import com.example.craysafenew.utility.SessionManager
import com.example.craysafenew.databinding.LoginuiBinding

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import kotlin.jvm.java
import kotlinx.coroutines.launch


import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginuiBinding
    private lateinit var sessionManager: SessionManager
    private val viewMode: LoginAuth by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        sessionManager = SessionManager(this)

        // IF USER IS ALREADY LOGGED IN
        if(sessionManager.getloggedinstatus()){
            startActivity(Intent(this, Dashboardfragment::class.java))
            finish()
            return
        }

        binding = LoginuiBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun observeviewmodel(){
        viewMode.loading.observe(this){
            isLoading -> binding.progressbar.visibility =
            if (isLoading) View.VISIBLE else View.GONE //SHORTCUT MODE FOR IF STATEMENT W/H BRACKETS

            binding.emailtext.isEnabled = !isLoading
            binding.passwordtext.isEnabled = !isLoading
            binding.signinbutton.isEnabled = !isLoading



        }
    }
}