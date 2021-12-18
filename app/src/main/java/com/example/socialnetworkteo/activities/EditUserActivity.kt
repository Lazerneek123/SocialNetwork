package com.example.socialnetworkteo.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.models.User
import com.example.socialnetworkteo.models.UserData
import com.example.socialnetworkteo.viewModel.EditUserViewModel

class EditUserActivity : AppCompatActivity() {
    private lateinit var viewModel: EditUserViewModel

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)

        viewModel = ViewModelProvider(this)[EditUserViewModel::class.java]

        val id = intent.extras?.getInt("id")!!.toInt()
        viewModel.loadUserData(id)

        val userData = UserData()
        val friend1Image: ImageView = findViewById(R.id.userEditImage)
        friend1Image.setImageResource(userData.userList.value!![id].photo)

        val nameFriend1: EditText = findViewById(R.id.textEditUserName)
        nameFriend1.setText(userData.userList.value!![id].name)

        val postFriend1: EditText = findViewById(R.id.textEditUserPost)
        postFriend1.setText(userData.userList.value!![id].post)

        val ageFriend1: EditText = findViewById(R.id.textEditUserAge)
        ageFriend1.setText(userData.userList.value!![id].age.toString())

        val emailFriend1: EditText = findViewById(R.id.textEditUserEmail)
        emailFriend1.setText(userData.userList.value!![id].email)

        val hobbyFriend1: EditText = findViewById(R.id.textEditUserHobby)
        hobbyFriend1.setText(userData.userList.value!![id].hobby)

        val descriptionFriend1: EditText = findViewById(R.id.textEditUserDescription)
        descriptionFriend1.setText(userData.userList.value!![id].description)

        val updateButton = findViewById<Button>(R.id.buttonUpdate)
        updateButton.setOnClickListener {
            updateUserInfo()
            finish()
        }
    }

    private fun updateUserInfo() {
        val newUserName = findViewById<EditText>(R.id.textEditUserName).text.toString()
        val newUserPost = findViewById<EditText>(R.id.textEditUserPost).text.toString()
        val newUserAge = findViewById<EditText>(R.id.textEditUserAge).text.toString().toInt()
        val newEmail = findViewById<EditText>(R.id.textEditUserEmail).text.toString()
        val newHobby = findViewById<EditText>(R.id.textEditUserHobby).text.toString()
        val newDescription = findViewById<EditText>(R.id.textEditUserDescription).text.toString()
        val id = intent.extras?.getInt("id")

        val user = User(
            id!!,
            newUserName,
            newUserPost,
            newUserAge,
            onlineStatus[(0..4).random()],
            newEmail,
            viewModel.user.value!!.photo,
            newHobby,
            newDescription
        )
        viewModel.updateUserInfo(user)
    }

    private val onlineStatus = listOf(
        (1..59).random().toString() + " min ago",
        "Online",
        (1..23).random().toString() + " hours ago",
        "Yesterday",
        (1..11).random().toString() + " month ago"
    )

}