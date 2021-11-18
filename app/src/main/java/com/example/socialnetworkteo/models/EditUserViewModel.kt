package com.example.socialnetworkteo.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialnetworkteo.database.UserDatabase

class EditUserViewModel(application: Application) : AndroidViewModel(application) {
    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    fun loadUserData(id: Int) {
        _userLiveData.value = database.get(id)
    }

    fun updateUserInfo(user: User) {
        database.update(user)
    }
}