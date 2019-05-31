package com.example.todoey.domain.interactors

import com.example.todoey.contractors.TaskContract
import com.example.todoey.domain.entities.Task
import com.example.todoey.domain.repository.TaskRepository
import com.example.todoey.domain.repository.local.RoomRepositoryAdapter
import com.example.todoey.domain.repository.local.TaskRoomRepository

class AddTask(val taskDao: TaskRoomRepository): TaskContract.Interactor<Task, Unit> {

    override fun execute(task: Task?) {
        taskDao.create(task)
    }

}