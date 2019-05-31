package com.example.todoey.domain.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoey.domain.entities.Task

@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class LocalTaskRepository: RoomDatabase() {
    abstract fun taskDao(): TaskRoomRepository
}