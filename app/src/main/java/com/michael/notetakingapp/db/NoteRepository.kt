package com.michael.notetakingapp.db

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.michael.notetakingapp.dao.NoteDao
import com.michael.notetakingapp.models.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(application: Application)
{
    private var noteDao : NoteDao
    private var allNotes : LiveData<List<Note>>


    init {
    val database : NoteDatabase = NoteDatabase
        .getInstance(application.applicationContext)!!

        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()

    }


    fun insertNewNote(note: Note)
    {
        CoroutineScope(Dispatchers.IO)
            .launch {
                noteDao.addNewNote(note)
            }
    }

    fun getAllNotes(): LiveData<List<Note>> = allNotes


}