package com.geeks.noteapp2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.noteapp2.data.db.daos.NoteDao
import com.geeks.noteapp2.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}