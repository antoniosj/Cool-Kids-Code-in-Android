package com.antoniosj.livedataapp

import android.app.Application
import com.antoniosj.livedataapp.di.firestoreModule
import com.antoniosj.livedataapp.di.repositoryModule
import com.antoniosj.livedataapp.di.viewModelModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.android.startKoin

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        startKoin(this, listOf(firestoreModule, repositoryModule, viewModelModule))
    }
}