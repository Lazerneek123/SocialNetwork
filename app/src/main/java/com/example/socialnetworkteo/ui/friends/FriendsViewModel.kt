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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FriendsViewModel(application: Application) : AndroidViewModel(application) {

    private var usersData: UserData = UserData()

    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    private val _getSizeList = MutableLiveData(0)
    val getSizeList: LiveData<Int> = _getSizeList

    @SuppressLint("NullSafeMutableLiveData")
    fun getAllUsers() {
        database.run {
            viewModelScope.launch(Dispatchers.Main) {
                if (listEmpty() == null) {
                    for (userOne in usersData.userList.value!!) {
                        insert(userOne)
                    }
                }
                _userLiveData.value = getAllUsers()
                _getSizeList.value = database.getSize()!!
            }
        }
    }

    suspend fun loadUserData(id: Int) {
        _user.value = database.getId(id)
    }
}
