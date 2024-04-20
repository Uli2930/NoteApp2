package com.geeks.noteapp2.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared" , Context.MODE_PRIVATE)
    }

    var title: String?
        get() = sharedPreferences.getString("title", "")
        set(value) = sharedPreferences.edit().putString("title", value).apply()

    var isOnBoard: Boolean
        get() {
            return if (::sharedPreferences.isInitialized) {
                sharedPreferences.getBoolean("board", false)
            } else {
                false
            }
        }
        set(value) {
            sharedPreferences.edit().putBoolean("board", value).apply()
        }
}