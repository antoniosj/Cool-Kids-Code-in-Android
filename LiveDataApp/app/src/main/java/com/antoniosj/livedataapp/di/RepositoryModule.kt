package com.antoniosj.livedataapp.di

import com.antoniosj.livedataapp.repository.IUserRepository
import com.antoniosj.livedataapp.repository.UserFireStoreDataSource
import org.koin.dsl.module.module

val repositoryModule = module {

    single  {  UserFireStoreDataSource(get()) as IUserRepository  }

}