package com.example.kotlin_navigation_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_navigation_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.action_add -> replaceFragment(FragmentAdd())
                R.id.action_videos -> replaceFragment(FragmentVideos())
                R.id.action_profile -> replaceFragment(FragmentProfile())
                R.id.action_details -> replaceFragment(FragmentAppDetails())

                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}