package com.example.roomdbapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //For changing the action button
        setupActionBarWithNavController(findNavController(R.id.fragment))





        //For going back
        fun onSupportNavigateUp():Boolean{
          val navController = findNavController(R.id.fragment)
            return navController.navigateUp() || super.onSupportNavigateUp()
        }

    }
}