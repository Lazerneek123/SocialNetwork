package com.example.socialnetworkteo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialnetworkteo.R

class UserData {

    private val onlineStatus = listOf((1..59).random().toString() + " min ago", "Online",
        (1..23).random().toString() + " hours ago", "Yesterday", (1..11).random().toString() + " month ago")

    private var _userList = MutableLiveData<List<User>>().apply {
        value = listOf()
    }
    var userList: LiveData<List<User>> = _userList

    init {
        val user1 = User(
            "Maks Rens", "Admin", 34, onlineStatus[(0..4).random()], "maksRens@gmail.com", R.drawable.user1,
            "Cars", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!"
        )

        val user2 = User(
            "Sara Derby", "Admin", 23, onlineStatus[(0..4).random()], "saraDerby@gmail.com", R.drawable.user2,
            "Collecting cards", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!"
        )

        val user3 = User(
            "Mark Twelve", "User", 21, onlineStatus[(0..4).random()], "makrTwelve@gmail.com", R.drawable.user3,
            "Fishing", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!"
        )

        val user4 = User(
            "Nick Tiger", "User", 22, onlineStatus[(0..4).random()], "nickTiger@gmail.com", R.drawable.user4,
            "Picking up mushrooms", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!"
        )

        val user5 = User(
            "Lora Brown", "User", 45, onlineStatus[(0..4).random()], "loraDrown@gmail.com", R.drawable.user5,
            "Photograph", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!"
        )

        val user6 = User(
            "Semi Worner", "User", 29, onlineStatus[(0..4).random()], "semiWorner@gmail.com", R.drawable.user6,
            "Biking", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!"
        )

        val user7 = User(
            "Susan Garbel", "User", 30, onlineStatus[(0..4).random()], "susanGarbel@gmail.com", R.drawable.user7,
            "Rock climbing", "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                    "There should be a description of the character! There should be a description of the character!"
        )

        _userList.value = listOf(user1, user2, user3, user4, user5, user6, user7)
    }
}