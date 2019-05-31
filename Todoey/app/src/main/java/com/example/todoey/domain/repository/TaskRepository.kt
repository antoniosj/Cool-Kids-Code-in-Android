package com.example.todoey.domain.repository


import androidx.lifecycle.LiveData
import com.example.todoey.domain.entities.Task

interface TaskRepository {

     fun insert(task: Task?)
     fun readAll() : LiveData<List<Task>>
}

