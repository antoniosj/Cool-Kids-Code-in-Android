package com.antoniosj.livedataapp.feature.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.antoniosj.livedataapp.entity.User
import com.antoniosj.livedataapp.repository.IUserRepository

class UserViewModel(private val userRepository: IUserRepository) : ViewModel() {

    private val userData: LiveData<List<User>> = userRepository.getAllUsers()


    fun addUser(user: User) {
        userRepository.addUser(user)
    }

    fun getAllUsers() = userData

}