package com.example.socialnetworkteo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.ui.friends.FriendsViewModel


class UserActivity : AppCompatActivity() {
    private lateinit var viewModel: FriendsViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        viewModel = ViewModelProvider(this).get(FriendsViewModel::class.java)

        val userName: TextView = findViewById(R.id.userName)
        val userStatus: TextView = findViewById(R.id.userStatus)
        val textStatus: TextView = findViewById(R.id.useTitle)
        val userTitle: TextView = findViewById(R.id.detailsTextAboutMe)
        val userImage: ImageView = findViewById(R.id.userImage)
        val id = intent.extras?.getInt("id")

        viewModel.userData.observe(this, {

            userName.text = it.userList[id!!].name.value
            userStatus.text = "Post: " + it.userList[id].post.value + " | Age: " + it.userList[id].age.value
            userImage.setImageResource(it.userList[id].photo.value!!)
            textStatus.text = "Hobby: " + it.userList[id].hobby.value + " | Email: " + it.userList[id].email.value
            userTitle.text = it.userList[id].description.value
        })
    }
}
