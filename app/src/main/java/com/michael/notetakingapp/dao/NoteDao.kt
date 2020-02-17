package com.michael.notetakingapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.michael.notetakingapp.models.Note

@Dao
interface NoteDao
{

    @Insert
    fun addNewNote(newNote: Note)

    @Query("select * from note_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note)

}