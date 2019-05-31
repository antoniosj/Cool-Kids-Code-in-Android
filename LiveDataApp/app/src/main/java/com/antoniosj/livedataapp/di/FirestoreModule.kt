package com.antoniosj.livedataapp.di

import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module.module

val firestoreModule = module {
    single { FirebaseFirestore.getInstance() }

    single {get<FirebaseFirestore>().collection("users") }

}