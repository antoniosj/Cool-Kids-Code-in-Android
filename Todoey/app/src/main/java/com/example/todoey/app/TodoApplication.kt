package com.example.todoey.app

import android.app.Application
import com.example.todoey.di.appModule
import com.example.todoey.domain.repository.local.LocalTaskRepository
import org.koin.android.ext.android.startKoin

class TodoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}