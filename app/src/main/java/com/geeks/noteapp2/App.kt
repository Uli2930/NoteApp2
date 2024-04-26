package com.geeks.noteapp2

import android.app.Application
import androidx.room.Room
import com.geeks.noteapp2.data.db.AppDatabase
import com.geeks.noteapp2.utils.PreferenceHelper

class App : Application() {

    companion object {
        var appDataBase: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
        getInstance()
    }

    fun getInstance(): AppDatabase? {
        if (appDataBase == null) {
            appDataBase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDataBase
    }
}