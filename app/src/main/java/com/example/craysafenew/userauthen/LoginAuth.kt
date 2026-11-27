package com.example.craysafenew.userauthen

//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import com.example.craysafenew.databinding.LoginuiBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.craysafenew.ApiBuilder
import kotlinx.coroutines.launch

class LoginAuth : ViewModel(){
//    private lateinit var binding: LoginuiBinding
    private val Login_result = MutableLiveData<loginrequests>()
    val loginresult: LiveData<loginrequests> = Login_result

    private val isLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = isLoading

    private val error = MutableLiveData<String?>()
    val Error: LiveData<String?> = error

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = LoginuiBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)

    fun loginuser(email: String, password: String){
        isLoading.value = true
        error.value = null

        viewModelScope.launch {
            try{
                val response = ApiBuilder.Apiinterface.login(email, password)
                isLoading.value = false

                if(response.success){
                    loginresult.value = loginresponses.logindata(
                        token = response.data?.token?:"",
                        user = response.data?.user
                    )
                }

            } catch (e: Exception){

            }
        }



    }
}



//ViewModel()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = LoginuiBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        val emaillabel = findViewById<EditText>(R.id.emailtext)
//        val passwordlabel = findViewById<EditText>(R.id.passwordtext)
//
//        val signinevent = findViewById<Button>(R.id.signinbutton)
//
//        signinevent.setOnClickListener {
//            val emaillabel = emaillabel.text.toString()
//            val passwordinput = passwordlabel.text.toString()
//
//            //REQUESTS FOR API
//            val request = loginrequests(
//                email = emaillabel,
//                password = passwordinput
//            )
//
//            //API BUILDER
//            ApiBuilder.apiinterface.login(request)
//                .enqueue(object : Callback<ResponseApi>{
//                    override fun onResponse(
//                        call: Call<ResponseApi>,
//                        response: Response<ResponseApi>
//                    ){
//                        if(response.isSuccessful()){
//                            val result = response.body()
//
//                            Toast.makeText(
//                                this@LoginActivity,
//                                result?.message,
//                                Toast.LENGTH_LONG
//                            ).show()
//
//                        }else{
//                            Toast.makeText(
//                                this@LoginActivity,
//                                "Login failed${response.code()}",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//                    // RESPOSE IF FAIL
//                    override fun onFailure(
//                        call: Call<ResponseApi>,
//                        t: Throwable
//                    ){
//                        Toast.makeText(
//                            this@LoginActivity,
//                            "Connection error: ${t.message}",
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//
//
//                })
//
//
//        }
//
//        fun registerlink(){
//            val registerlink = findViewById<TextView>(R.id.registerLink)
//
//            registerlink.setOnClickListener {
//
//                val intent = Intent(this, RegisterActivity::class.java)
//
//            }
//
//        }
//
//        registerlink()
//
//    }

