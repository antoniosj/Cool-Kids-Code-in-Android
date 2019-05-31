package com.example.todoey.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task(val title: String) {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}