package com.example.socialnetworkteo.viewModel

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

    private val _usersList = MutableLiveData<List<User>>()
    val usersList: LiveData<List<User>> = _usersList

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _getSizeList = MutableLiveData<Int>()
    val getSizeList: LiveData<Int> = _getSizeList

    fun getAllUsers() {
        viewModelScope.launch {
            if (database.listEmpty() == null) {
                for (userOne in usersData.userList.value!!) {
                    database.insert(userOne)
                }
            }

            _usersList.value = database.getAllUsers()
            _getSizeList.value = database.getSize()!! - 1
        }
    }

    fun loadUserData(id: Int) {
        viewModelScope.launch {
            _user.value = database.getId(id)
        }
    }
}
