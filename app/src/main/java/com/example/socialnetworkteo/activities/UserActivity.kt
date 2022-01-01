package com.example.socialnetworkteo.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.viewModel.UserViewModel

class UserActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        id = intent.extras?.getInt(MainActivity.EXTRA_MESSAGE)!!
        viewModel.loadUserData(id)

        viewModel.userLiveData.observe(this, {
            findViewById<TextView>(R.id.userName).text = it.name
            findViewById<TextView>(R.id.userPost).text = it.post
            findViewById<TextView>(R.id.userAge).text = it.age.toString()
            findViewById<ImageView>(R.id.userImage).setImageResource(it.photo)
            findViewById<TextView>(R.id.userTitle).text = it.hobby
            findViewById<TextView>(R.id.userEmail).text = it.email
            findViewById<TextView>(R.id.detailsTextAbout).text = it.description
        })
    }

    fun editUser(view: View) {
        val intent = Intent(this, EditUserActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_MESSAGE, id)
        startActivity(intent)
        finish()
    }
}
