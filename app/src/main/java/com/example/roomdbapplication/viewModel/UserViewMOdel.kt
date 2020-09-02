package com.example.roomdbapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdbapplication.data.UserDatabase
import com.example.roomdbapplication.repository.UserRepo
import com.example.roomdbapplication.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewMOdel(application: Application):AndroidViewModel(application) {

     val readAllData:LiveData<List<User>>

    private val repository: UserRepo

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepo(userDao)
        readAllData = repository.readAllData

    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

}