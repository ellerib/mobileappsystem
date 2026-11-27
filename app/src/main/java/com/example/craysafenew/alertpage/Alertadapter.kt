package com.example.craysafenew.alertpage
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.craysafenew.alertnotif
import com.example.craysafenew.databinding.FragmentAlertBinding
import okhttp3.Callback
import okio.Inflater

class Alertadapter (
    private val binding: FragmentAlertBinding,
    private val onAlertClick: (alertnotif) -> Unit
): RecyclerView.Adapter<alertnotif,Alertadapter.Alertviewholder>(){

    override fun onCreateViewHolder(){


    }
    class Alertviewholder(){
        fun bind(alertnotif: alertnotif){

        }
    }

}