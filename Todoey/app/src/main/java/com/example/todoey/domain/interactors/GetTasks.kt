package com.example.todoey.domain.interactors

import androidx.lifecycle.LiveData
import com.example.todoey.contractors.TaskContract
import com.example.todoey.domain.entities.Task
import com.example.todoey.domain.repository.TaskRepository
import com.example.todoey.domain.repository.local.RoomRepositoryAdapter
import com.example.todoey.domain.repository.local.TaskRoomRepository

class GetTasks(val taskDao: TaskRoomRepository) : TaskContract.Interactor<Unit, LiveData<List<Task>>> {

    override fun execute(param: Unit?): LiveData<List<Task>>? {
        return taskDao?.getTasks()
    }

}