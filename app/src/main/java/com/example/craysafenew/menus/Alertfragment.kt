package com.example.craysafenew.menus

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.craysafenew.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.craysafenew.ApiBuilder
import com.example.craysafenew.alertpage.Alertadapter
import com.example.craysafenew.alertnotif

// ALERT FRAGMENT
class Alertfragment : Fragment(R.layout.fragment_alert) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Alertadapter
    private lateinit var unreadstatus: TextView

    // CONNECT TO RESPONSE API
    private val alerts = mutableListOf<alertnotif>()

    override fun onViewCreated(view: View,savedInstanceState: Bundle?){

        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.alertbox)
        unreadstatus = view.findViewById(R.id.unreadstatus)

        adapter = Alertadapter(alerts)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter

        // GETTING XML REFERENCE FOR DATA TO DISPLAY
        val alertdate = view.findViewById<TextView>(R.id.alertdate)
        val severity = view.findViewById<TextView>(R.id.severity)
        val parameter = view.findViewById<TextView>(R.id.parameter)
        val description = view.findViewById<TextView>(R.id.description)
        val suggestions = view.findViewById<TextView>(R.id.suggestion)
        val advice = view.findViewById<TextView>(R.id.advice)
        val message = view.findViewById<TextView>(R.id.message)
        val status = view.findViewById<TextView>(R.id.status)
        val tankname = view.findViewById<TextView>(R.id.tankname)

        // CONVERTING TO STRING
        val alertdatefield = alertdate.text.toString()
        val severityfield = severity.text.toString()
        val parameterfield = parameter.text.toString()
        val descriptionfield = description.text.toString()
        val suggestionsfield = suggestions.text.toString()
        val advicefield = advice.text.toString()
        val messagefield = message.text.toString()
        val statusfield = status.text.toString()
        val tanknamefield = tankname.text.toString()

        val alertrequests = alertnotif(
            alertdate = alertdatefield,
            severity = severityfield,
            parameter = parameterfield,
            description = descriptionfield,
            suggestion = suggestionsfield,
            advice = advicefield,
            message = messagefield,
            status = statusfield,
            tankname = tanknamefield
        )
        // FETCH API
        ApiBuilder.apiinterface.getalerts(alertrequests)


    }

    private fun displayalerts(newAlerts: List<alertnotif>){
        alerts.clear()
        alerts.add(newAlerts)

        alerts


    }



}