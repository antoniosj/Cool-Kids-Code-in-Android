package com.example.todoey.domain.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.todoey.domain.entities.Task

@Dao
interface TaskRoomRepository {
    @Insert(onConflict = IGNORE)
    fun create(task: Task?)

    @Query("SELECT * FROM Task")
    fun getTasks() : LiveData<List<Task>>
}