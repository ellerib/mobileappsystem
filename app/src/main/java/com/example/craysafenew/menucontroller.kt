package com.example.craysafenew
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.craysafenew.menus.Alertfragment
import com.example.craysafenew.menus.Dashboardfragment
import com.example.craysafenew.menus.reportfragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.craysafenew.databinding.MenuDesignBinding

class menucontroller : AppCompatActivity() {
    private lateinit var binding: MenuDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // VIEW THE MENU_DESIGN.XML USING BINDING
        binding  = MenuDesignBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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