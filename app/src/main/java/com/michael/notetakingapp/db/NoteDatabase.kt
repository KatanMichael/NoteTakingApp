package com.michael.notetakingapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.michael.notetakingapp.dao.NoteDao
import com.michael.notetakingapp.models.Note

@Database (entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase()
{
    abstract fun noteDao(): NoteDao

    companion object
    {
        private var instance : NoteDatabase? = null

        fun getInstance(context: Context) : NoteDatabase?
        {
            if(instance == null)
            {
                synchronized(NoteDatabase::class.java)
                {
                    instance = Room.databaseBuilder(context,
                        NoteDatabase::class.java,
                        "note_datebase")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance
        }




    }

}