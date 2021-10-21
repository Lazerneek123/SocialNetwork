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
        val id = intent.extras?.getInt(MainActivity.EXTRA_MESSAGE)!!


        viewModel.userData.observe(this, {

            userName.text = it.userList.value!![id].name
            userStatus.text = "Post: " + it.userList.value!![id].post + " | Age: " + it.userList.value!![id].age
            userImage.setImageResource(it.userList.value!![id].photo)
            textStatus.text = "Hobby: " + it.userList.value!![id].hobby + " | Email: " + it.userList.value!![id].email
            userTitle.text = it.userList.value!![id].description
        })
    }
}
