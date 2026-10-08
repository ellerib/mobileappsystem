package com.example.craysafenew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.widget.Toast
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeractivity)

        val usernametext = findViewById<EditText>(R.id.usernamelabel)
        val passwordtext = findViewById<EditText>(R.id.passwordregister)
        val productidtext = findViewById<EditText>(R.id.productidlabel)
        val emailtext = findViewById<EditText>(R.id.emailtext)

        val createaccount = findViewById<Button>(R.id.createlink)
        val signinlink = findViewById<TextView>(R.id.signinlink)

        createaccount.setOnClickListener {

            val usernamefield = usernametext.text.toString()
            val passwordfield = passwordtext.text.toString()
            val productidfield = productidtext.text.toString()
            val emailfield = emailtext.text.toString()

            // INITIALIZING FOR THE REQUEST
            val requests = registerrequests(
                username = usernamefield,
                password = passwordfield,
                productid = productidfield,
                email = emailfield
            )

            ApiBuilder.apiinterface.register(requests)

                .enqueue(object : Callback<ResponseApi> {

                    // RESPONSE FUNCTION
                    override fun onResponse(
                        call: Call<ResponseApi>,
                        response: Response<ResponseApi>
                    ) {

                        // RESPONSE IF SUCCESSFUL
                        if (response.isSuccessful) {

                            val result = response.body()

                            Toast.makeText(
                                this@RegisterActivity,
                                result?.message,
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            Toast.makeText(
                                this@RegisterActivity,
                                "Registration failed: ${response.code()}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    // RESPONSE IF FAILED
                    override fun onFailure(
                        call: Call<ResponseApi>,
                        t: Throwable
                    ) {

                        Toast.makeText(
                            this@RegisterActivity,
                            "Connection error: ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
        signinlink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }

    }
}