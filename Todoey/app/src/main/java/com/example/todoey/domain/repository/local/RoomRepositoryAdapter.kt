package com.example.todoey.domain.repository.local

import androidx.lifecycle.LiveData
import com.example.todoey.domain.entities.Task
import com.example.todoey.domain.repository.TaskRepository

class RoomRepositoryAdapter(val taskDao: TaskRoomRepository): TaskRepository {

    override fun readAll(): LiveData<List<Task>> {
        val liveData: LiveData<List<Task>>? = taskDao.getTasks()
        return liveData!!
    }

    override fun insert(task: Task?) {
        taskDao.create(task)
    }

}