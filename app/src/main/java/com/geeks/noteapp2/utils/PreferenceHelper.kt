package com.geeks.noteapp2.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }
    var isOnBoard: Boolean
        get() = sharedPreferences.getBoolean("board", false)
        set(value) = sharedPreferences.edit().putBoolean("board", value).apply()

    var isSignUp: Boolean
        get() = sharedPreferences.getBoolean("key", false)
        set(value) = sharedPreferences.edit().putBoolean("key", value).apply()
}