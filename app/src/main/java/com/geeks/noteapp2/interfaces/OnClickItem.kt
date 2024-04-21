package com.geeks.noteapp2.interfaces

import com.geeks.noteapp2.data.model.NoteModel

interface OnClickItem {
    fun onLongClick(noteModel: NoteModel)
    fun onClick(noteModel: NoteModel)
}