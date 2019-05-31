package com.antoniosj.livedataapp.di

import com.antoniosj.livedataapp.feature.user.UserViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {

    viewModel { UserViewModel(get()) }

}