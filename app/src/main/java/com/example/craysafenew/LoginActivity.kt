package com.example.craysafenew

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emaillabel = findViewById<EditText>(R.id.emailtext)
        val passwordlabel = findViewById<EditText>(R.id.passwordtext)

        val signinevent = findViewById<Button>(R.id.signinbutton)

        signinevent.setOnClickListener {
            val emaillabel = emaillabel.text.toString()
            val passwordinput = passwordlabel.text.toString()

            //REQUESTS FOR API
            val request = loginrequests(
                email = emaillabel,
                password = passwordinput
            )

            //API BUILDER
            ApiBuilder.apiinterface.login(request)
                .enqueue(object : Callback<ResponseApi>{
                    override fun onResponse(
                        call: Call<ResponseApi>,
                        response: Response<ResponseApi>
                    ){
                        if(response.isSuccessful()){
                            val result = response.body()

                            Toast.makeText(
                                this@LoginActivity,
                                result?.message,
                                Toast.LENGTH_LONG
                            ).show()

                        }else{
                            Toast.makeText(
                                this@LoginActivity,
                                "Login failed${response.code()}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    // RESPOSE IF FAIL
                    override fun onFailure(
                        call: Call<ResponseApi>,
                        t: Throwable
                    ){
                        Toast.makeText(
                            this@LoginActivity,
                            "Connection error: ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                })


        }

        fun registerlink(){
            val registerlink = findViewById<TextView>(R.id.registerLink)

            registerlink.setOnClickListener {

                val intent = Intent(this, RegisterActivity::class.java)

            }

        }

        registerlink()

    }
}