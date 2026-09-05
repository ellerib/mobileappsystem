package com.example.craysafenew

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.widget.Toast

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeractivity)

        val fullname = findViewById<EditText>(R.id.fullnametext)
        val email = findViewById<EditText>(R.id.emailtext)
        val password = findViewById<EditText>(R.id.passwordregister)
        val confirmpass = findViewById<EditText>(R.id.confirmpass)
        val createaccount = findViewById<Button>(R.id.createlink)
        val signinlink = findViewById<TextView>(R.id.signinlink)

        createaccount.setOnClickListener{

            val name = fullname.text.toString()
            val useremail = email.text.toString();
            val userpassword = password.text.toString()
            val confirm = confirmpass.text.toString()

            if (name.isEmpty()||useremail.isEmpty()||userpassword.isEmpty()||
                confirm.isEmpty()
                ){
                //
            }else if(password!=confirmpass){
                // DONT MATCH
            }else{
                // PHP API
            }

        }

        signinlink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }

    }
}