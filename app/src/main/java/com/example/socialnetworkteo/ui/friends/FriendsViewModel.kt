package com.example.socialnetworkteo.ui.friends

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.socialnetworkteo.database.UserDatabase
import com.example.socialnetworkteo.models.User
import com.example.socialnetworkteo.models.UserData
import kotlinx.coroutines.launch

class FriendsViewModel(application: Application) : AndroidViewModel(application) {

    private var usersData: UserData = UserData()

    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    @SuppressLint("NullSafeMutableLiveData")
    fun getAllUsers() {
        database.run {
            viewModelScope.launch {
                if (listEmpty() == null) {
                    for (user in usersData.userList.value!!) {
                        insert(user)
                    }
                }
                _userLiveData.value = getAllUsers()
            }
            viewModelScope.launch {
                _userLiveData.value = getAllUsers()
            }
        }
    }
}
