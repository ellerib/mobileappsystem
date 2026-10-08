package com.example.craysafenew.alert_operation

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.craysafenew.ResponseApi
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import com.example.craysafenew.R

import com.example.craysafenew.alertrequests
import com.example.craysafenew.alertresponse

abstract class Alertadapter(
    private val alertrequests: List<alertrequests>
): RecyclerView.Adapter<Alertadapter.Alertviewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, Viewtype: Int): Alertadapter.Alertviewholder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_first_fragment,
            parent, false)
        return Alertviewholder(view)

    }
    class Alertviewholder(view: View):
        RecyclerView.ViewHolder(view){
        val severity: TextView
        val parameter: TextView
        val description: TextView

        init {
            severity = view.findViewById(R.id.severity)
            parameter = view.findViewById(R.id.parameter)
            description = view.findViewById(R.id.description)
        }

    }
}