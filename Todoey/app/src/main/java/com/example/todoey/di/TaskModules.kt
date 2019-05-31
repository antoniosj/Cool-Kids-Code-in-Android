package com.example.todoey.di

import androidx.room.Room
import com.example.todoey.contractors.TaskContract
import com.example.todoey.domain.interactors.AddTask
import com.example.todoey.domain.interactors.GetTasks
import com.example.todoey.domain.repository.local.LocalTaskRepository
import com.example.todoey.domain.repository.local.RoomRepositoryAdapter
import com.example.todoey.domain.repository.local.TaskRoomRepository
import com.example.todoey.presenters.TaskPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.applicationContext
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory


val appModule = module {

    factory {TaskPresenter(get(), get()) as TaskContract.Presenter}

    single {
        Room.databaseBuilder(androidContext(),
                             LocalTaskRepository::class.java,
                      "task-database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    factory { get<LocalTaskRepository>().taskDao() }
    factory { AddTask(get()) }
    factory { GetTasks(get()) }
    factory { RoomRepositoryAdapter(get()) }

}