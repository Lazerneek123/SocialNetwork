package com.example.socialnetworkteo.models

import androidx.lifecycle.MutableLiveData
import com.example.socialnetworkteo.R

class UserData {
    private val onlineStatus = listOf(
        (1..59).random().toString() + " min ago",
        "Online",
        (1..23).random().toString() + " hours ago",
        "Yesterday",
        (1..11).random().toString() + " month ago"
    )

    private var _userList = MutableLiveData<List<User>>().apply {
        value = listOf(
            User(
                0,
                "Maks Rens",
                "Admin",
                34,
                onlineStatus[(0..4).random()],
                "maksRens@gmail.com",
                R.drawable.user1,
                "Cars",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!"
            ),

            User(
                1,
                "Sara Derby",
                "Admin",
                23,
                onlineStatus[(0..4).random()],
                "saraDerby@gmail.com",
                R.drawable.user2,
                "Collecting cards",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!"
            ),

            User(
                2,
                "Mark Twelve",
                "User",
                21,
                onlineStatus[(0..4).random()],
                "makrTwelve@gmail.com",
                R.drawable.user3,
                "Fishing",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!"
            ),

            User(
                3,
                "Nick Tiger",
                "User",
                22,
                onlineStatus[(0..4).random()],
                "nickTiger@gmail.com",
                R.drawable.user4,
                "Picking up mushrooms",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!"
            ),

            User(
                4,
                "Lora Brown",
                "User",
                45,
                onlineStatus[(0..4).random()],
                "loraDrown@gmail.com",
                R.drawable.user5,
                "Photograph",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!"
            ),

            User(
                5,
                "Semi Worner",
                "User",
                29,
                onlineStatus[(0..4).random()],
                "semiWorner@gmail.com",
                R.drawable.user6,
                "Biking",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!"
            ),

            User(
                6,
                "Susan Garbel",
                "User",
                30,
                onlineStatus[(0..4).random()],
                "susanGarbel@gmail.com",
                R.drawable.user7,
                "Rock climbing",
                "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!" + "There should be a description of the character! There should be a description of the character!" +
                        "There should be a description of the character! There should be a description of the character!"
            )
        )
    }
    var userList = _userList
}