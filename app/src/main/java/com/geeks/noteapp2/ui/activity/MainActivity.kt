package com.geeks.noteapp2.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.geeks.noteapp2.R
import com.geeks.noteapp2.databinding.ActivityMainBinding
import com.geeks.noteapp2.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHostFragment.navController

        preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(applicationContext)

        if (!preferenceHelper.isOnBoard) {
            navController.navigate(R.id.onBoardFragment)
            preferenceHelper.isOnBoard = true
        } else {
            navController.navigate(R.id.noteFragment)

        }
    }
}