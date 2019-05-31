package com.example.todoey.contractors

import androidx.lifecycle.LiveData
import com.example.todoey.domain.entities.Task

interface TaskContract {

    interface View {
        fun initView()
    }

    interface Presenter {
        fun addTaskCalled(title:String)
        fun getTasks() : LiveData<List<Task>>
    }

    interface Interactor<P, Q> {

        fun execute(param: P?) : Q?
    }

}