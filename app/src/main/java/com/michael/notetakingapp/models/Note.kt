package com.michael.notetakingapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "note_table")
data class Note(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                val title: String,
                val data: String,
                val date: String)
{


}