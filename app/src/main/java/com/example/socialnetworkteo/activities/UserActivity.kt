package com.example.socialnetworkteo.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.ui.friends.FriendsViewModel

class UserActivity : AppCompatActivity() {
    private lateinit var viewModel: FriendsViewModel
    private var id: Int = 0

    @SuppressLint("SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        viewModel = ViewModelProvider(this)[FriendsViewModel::class.java]
        viewModel.getAllUsers()

        id = intent.extras?.getInt(MainActivity.EXTRA_MESSAGE)!!

        viewModel.userLiveData.observe(this, {
            findViewById<TextView>(R.id.userName).text = it[id].name
            findViewById<TextView>(R.id.userPost).text = it[id].post
            findViewById<TextView>(R.id.userAge).text = it[id].age.toString()
            findViewById<ImageView>(R.id.userImage).setImageResource(it[id].photo)
            findViewById<TextView>(R.id.userTitle).text = it[id].hobby
            findViewById<TextView>(R.id.userEmail).text = it[id].email
            findViewById<TextView>(R.id.detailsTextAbout).text = it[id].description
        })
    }

    fun editUser(view: View) {
        val intent = Intent(this, EditUserActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_MESSAGE, id)
        startActivity(intent)
        finish()
    }
}
