package com.example.craysafenew.menus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.craysafenew.R
import androidx.lifecycle.ViewModel

// ALERT FRAGMENT
class Alertfragment : Fragment(R.layout.fragment_first_fragment) {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val warningtype = view?.findViewById<TextView>(R.id.warningtype)
        val typemodule = view?.findViewById<TextView>(R.id.typeofmodule)
        val description = view?.findViewById<TextView>(R.id.description)
        val suggestion = view?.findViewById<TextView>(R.id.suggestion)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_fragment, container, false)
    }

}