package com.example.roomdbapplication.repository

import androidx.lifecycle.LiveData
import com.example.roomdbapplication.data.UserDao
import com.example.roomdbapplication.model.User

class UserRepo(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
}