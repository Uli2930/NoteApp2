package com.geeks.noteapp2

import android.app.Application
import com.geeks.noteapp2.utils.PreferenceHelper

class App: Application() {


    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
    }
}