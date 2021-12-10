package com.example.socialnetworkteo.viewModel

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
    fun userLiveData(): LiveData<List<User>>{
       return _userLiveData
    }

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _getSizeList = MutableLiveData<Int>()
    fun getSizeList(): LiveData<Int>{
        return _getSizeList
    }

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    @SuppressLint("NullSafeMutableLiveData")
    fun getAllUsers() {
        database.run {
            viewModelScope.launch {
                if (listEmpty() == null) {
                    for (userOne in usersData.userList.value!!) {
                        insert(userOne)
                    }
                }

                _userLiveData.value = getAllUsers()
                _getSizeList.value = database.getSize()!! - 1
            }
        }
    }
}
