package com.example.todoey.presenters

import android.provider.Settings
import androidx.lifecycle.LiveData
import com.example.todoey.contractors.TaskContract
import com.example.todoey.domain.entities.Task
import com.example.todoey.domain.interactors.AddTask
import com.example.todoey.domain.interactors.GetTasks

class TaskPresenter(val addTask: AddTask, val getTasks: GetTasks): TaskContract.Presenter {

    private val TAG = "TaskPresenter"

    private val liveTasks  : LiveData<List<Task>> = getTasks.execute(null)!!

    override fun addTaskCalled(title: String) {
        //Log.d(TAG, "id: $id \n title: $title")
        addTask.execute(Task(title))
    }

    override fun getTasks() : LiveData<List<Task>> = liveTasks

}