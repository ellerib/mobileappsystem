package com.example.craysafenew.userauthen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.craysafenew.ApiBuilder
import com.example.craysafenew.ResponseApi
import com.example.craysafenew.databinding.RegisteractivityBinding
import com.example.craysafenew.registerrequests
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class RegisterActivity : ViewModel() {
    private lateinit var binding: RegisteractivityBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = RegisteractivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // REFERENCES ON XML REPLACED THE FINDBYID
//        binding.etusernamelabel
//        binding.passwordregister
//        binding.productidlabel
//        binding.emailtext
//        binding.createlink
//        binding.signinlink
//
//        binding.createlink.setOnClickListener {
//
//            val usernamefield = binding.etusernamelabel.text.toString()
//            val passwordfield = binding.passwordregister.text.toString()
//            val productidfield = binding.productidlabel.text.toString()
//            val emailfield = binding.emailtext.text.toString()
//
//            // INITIALIZING FOR THE REQUEST
//            val requests = registerrequests(
//                username = usernamefield,
//                password = passwordfield,
//                productid = productidfield,
//                email = emailfield
//            )
//
//            ApiBuilder.apiinterface.register(requests)
//
//                .enqueue(object : Callback<ResponseApi> {
//
//                    // RESPONSE FUNCTION
//                    override fun onResponse(
//                        call: Call<ResponseApi>,
//                        response: Response<ResponseApi>
//                    ) {
//
//                        // RESPONSE IF SUCCESSFUL
//                        if (response.isSuccessful) {
//
//                            val result = response.body()
//
//                            Toast.makeText(
//                                this@RegisterActivity,
//                                result?.message,
//                                Toast.LENGTH_SHORT
//                            ).show()
//
//                        } else {
//
//                            Toast.makeText(
//                                this@RegisterActivity,
//                                "Registration failed: ${response.code()}",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//
//                    // RESPONSE IF FAILED
//                    override fun onFailure(
//                        call: Call<ResponseApi>,
//                        t: Throwable
//                    ) {
//
//                        Toast.makeText(
//                            this@RegisterActivity,
//                            "Connection error: ${t.message}",
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                })
//        }
//        binding.signinlink.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//
//            finish()
//        }
//
//    }


}