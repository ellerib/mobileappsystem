package com.example.craysafenew
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.craysafenew.menus.Alertfragment
import com.example.craysafenew.menus.Dashboardfragment
import com.example.craysafenew.menus.reportfragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class menucontroller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // VIEW THE MENU_DESIGN.XML
        setContentView(R.layout.menu_design)

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationview)

        val alertfragment = Alertfragment()
        val dashboardfragment = Dashboardfragment()
        val reportfragment = reportfragment()

        bottomnav.setOnItemSelectedListener { item ->
            when(item.itemId){
                    R.id.alert -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment, alertfragment)
                            .commit()
                        true
                    }

                    R.id.dashboard -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment, dashboardfragment)
                            .commit()
                        true
                    }

                    R.id.reports -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment, reportfragment)
                            .commit()
                        true
                    }

                else -> false
            }
        }

    }
}