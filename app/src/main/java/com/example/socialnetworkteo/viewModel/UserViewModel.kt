package com.example.socialnetworkteo.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.socialnetworkteo.database.UserDatabase
import com.example.socialnetworkteo.models.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    fun loadUserData(id: Int) {
        viewModelScope.launch { _userLiveData.value = database.getId(id) }
    }
}