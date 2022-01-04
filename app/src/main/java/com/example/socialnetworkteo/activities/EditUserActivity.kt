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
import com.example.socialnetworkteo.viewModel.EditUserViewModel

class EditUserActivity : AppCompatActivity() {
    private lateinit var viewModel: EditUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)

        viewModel = ViewModelProvider(this)[EditUserViewModel::class.java]

        val id = intent.extras?.getInt("id")!!
        viewModel.loadUserData(id)

        viewModel.user.observe(this, {
            findViewById<ImageView>(R.id.userEditImage).setImageResource(it.photo)
            findViewById<EditText>(R.id.textEditUserName).setText(it.name)
            findViewById<EditText>(R.id.textEditUserPost).setText(it.post)
            findViewById<EditText>(R.id.textEditUserAge).setText(it.age.toString())
            findViewById<EditText>(R.id.textEditUserEmail).setText(it.email)
            findViewById<EditText>(R.id.textEditUserHobby).setText(it.hobby)
            findViewById<EditText>(R.id.textEditUserDescription).setText(it.description)
        })

        val updateButton = findViewById<Button>(R.id.buttonUpdate)
        updateButton.setOnClickListener {
            updateUserInfo(id)
            UserAdapter.activityFriendsFragment!!.recreate()
            finish()
        }
    }

    private fun updateUserInfo(id: Int) {
        val newUser = viewModel.user.value!!
        val newUserName = findViewById<EditText>(R.id.textEditUserName).text.toString()
        val newUserPost = findViewById<EditText>(R.id.textEditUserPost).text.toString()
        val newUserAge = findViewById<EditText>(R.id.textEditUserAge).text.toString().toInt()
        val newEmail = findViewById<EditText>(R.id.textEditUserEmail).text.toString()
        val newHobby = findViewById<EditText>(R.id.textEditUserHobby).text.toString()
        val newDescription = findViewById<EditText>(R.id.textEditUserDescription).text.toString()

        val user = User(
            newUserName,
            newUserPost,
            newUserAge,
            newUser.online,
            newEmail,
            newUser.photo,
            newHobby,
            newDescription
        )
        user.id = id
        viewModel.updateUserInfo(user)
    }
}