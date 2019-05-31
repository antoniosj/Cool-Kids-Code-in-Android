package com.antoniosj.livedataapp.repository

import androidx.lifecycle.LiveData
import com.antoniosj.livedataapp.entity.User

interface IUserRepository {
    fun addUser(user: User)

    fun getAllUsers(): LiveData<List<User>>
}