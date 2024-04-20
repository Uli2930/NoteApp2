package com.geeks.noteapp2.data.model

import android.graphics.Color
import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "noteModel" )
data class NoteModel(
    val title: String? = null,
    val description: String? = null,
    val date: String? = null,
    val time: String? = null,
    val color: Int = Color.BLACK
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
