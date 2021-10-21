package com.example.socialnetworkteo.ui.friends

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialnetworkteo.model.UserData

class FriendsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Select a friend"
    }
    val text: LiveData<String> = _text

    private val _userData = MutableLiveData<UserData>().apply {
        value = UserData()
    }
    val userData: LiveData<UserData> = _userData
}