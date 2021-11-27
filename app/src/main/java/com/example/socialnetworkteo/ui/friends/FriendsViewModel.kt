package com.example.socialnetworkteo.ui.friends

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialnetworkteo.database.UserDatabase
import com.example.socialnetworkteo.models.User
import com.example.socialnetworkteo.models.UserData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FriendsViewModel(application: Application) : AndroidViewModel(application) {

    private var usersData: UserData = UserData()

    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    private val database = UserDatabase.getInstance(application).userDatabaseDao

    fun fillUpDatabase() {
        if (database.isEmpty() == null) {
            for (user in usersData.userList.value!!) {
                database.run {
                    CoroutineScope(Dispatchers.IO).launch {
                        insert(user)
                    }
                }
            }
        }
    }

    fun loadUsersData() {
        _userLiveData.value = database.getAll()
    }
}
