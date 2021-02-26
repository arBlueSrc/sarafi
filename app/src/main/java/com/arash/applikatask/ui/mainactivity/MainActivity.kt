package com.arash.applikatask.ui.mainactivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.arash.applikatask.R
import com.arash.applikatask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()

        openBottomNavigation()
    }

    private fun openBottomNavigation() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.btmNav.animate().translationY(0f).setDuration(500).start()
        }, 4000)
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(binding.btmNav, navHostFragment.navController)
    }
}