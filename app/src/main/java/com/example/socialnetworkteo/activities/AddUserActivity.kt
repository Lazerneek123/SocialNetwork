package com.example.socialnetworkteo.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.adapter.UserAdapter
import com.example.socialnetworkteo.models.User
import com.example.socialnetworkteo.viewModel.AddUserViewModel

class AddUserActivity : AppCompatActivity() {
    private lateinit var viewModel: AddUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        viewModel = ViewModelProvider(this)[AddUserViewModel::class.java]

        val friendImage: ImageView = findViewById(R.id.userAddImage)
        friendImage.setImageResource(R.drawable.icon_my)

        val updateButton = findViewById<Button>(R.id.buttonSave)
        updateButton.setOnClickListener {
            insertNewUser()
            UserAdapter.activityFriendsFragment!!.recreate()
            finish()
        }
    }

    private fun insertNewUser() {
        var newUserName = findViewById<EditText>(R.id.textAddUserName).text.toString()
        if(newUserName == ""){
            newUserName = "New user"
        }
        val newUserPost = findViewById<EditText>(R.id.textAddUserPost).text.toString()
        var newUserAge = findViewById<EditText>(R.id.textAddUserAge).text.toString()
        if(newUserAge == ""){
            newUserAge = "0"
        }
        val newEmail = findViewById<EditText>(R.id.textAddUserEmail).text.toString()
        val newHobby = findViewById<EditText>(R.id.textAddUserHobby).text.toString()
        val newDescription = findViewById<EditText>(R.id.textAddUserDescription).text.toString()

        val user = User(
            newUserName,
            newUserPost,
            newUserAge.toInt(),
            onlineStatus[(0..4).random()],
            newEmail,
            R.drawable.icon_my,
            newHobby,
            newDescription
        )
        viewModel.insertUser(user)
    }

    private val onlineStatus = listOf(
        (1..59).random().toString() + " min ago",
        "Online",
        (1..23).random().toString() + " hours ago",
        "Yesterday",
        (1..11).random().toString() + " month ago"
    )
}