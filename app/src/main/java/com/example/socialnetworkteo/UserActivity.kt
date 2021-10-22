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
        val userTitle: TextView = findViewById(R.id.userTitle)
        val userDetailsTextAbout: TextView = findViewById(R.id.detailsTextAbout)
        val userImage: ImageView = findViewById(R.id.userImage)
        val id = intent.extras?.getInt(MainActivity.EXTRA_MESSAGE)!!


        viewModel.userData.observe(this, {
            userName.text = it.userList.value!![id].name
            userStatus.text = resources.getString(R.string.text_post) +
                    it.userList.value!![id].post + resources.getString(R.string.text_age) +
                    it.userList.value!![id].age
            userImage.setImageResource(it.userList.value!![id].photo)
            userTitle.text = resources.getString(R.string.text_hobby) +
                    it.userList.value!![id].hobby + resources.getString(R.string.text_email) +
                    it.userList.value!![id].email
            userDetailsTextAbout.text = it.userList.value!![id].description
        })
    }
}
