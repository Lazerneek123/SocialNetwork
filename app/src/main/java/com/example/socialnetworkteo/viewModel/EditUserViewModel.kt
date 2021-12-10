package com.example.socialnetworkteo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.socialnetworkteo.database.UserDatabase
import com.example.socialnetworkteo.models.User
import kotlinx.coroutines.launch

class EditUserViewModel(application: Application) : AndroidViewModel(application) {
    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    fun loadUserData(id: Int) {
        viewModelScope.launch { _userLiveData.value = database.getId(id) }
    }

    fun updateUserInfo(user: User) {
        database.run {
            viewModelScope.launch {
                update(user)
            }
        }
    }
}