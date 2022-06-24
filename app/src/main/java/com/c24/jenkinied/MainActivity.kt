package com.c24.jenkinied

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.c24.jenkinied.databinding.ActivityMainBinding
import com.c24.jenkinied.presentation.dashboard.DashboardFragmentDirections
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_dashboard, R.id.navigation_details, R.id.navigation_login))
        setupActionBarWithNavController(navController, appBarConfiguration)

        if (!userLoggedIn) navController.navigate(DashboardFragmentDirections.actionNavigationDashboardToNavigationLogin())
    }
}