package com.example.socialnetworkteo.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.ui.friends.FriendsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserActivity : AppCompatActivity() {
    private lateinit var viewModel: FriendsViewModel

    @SuppressLint("SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        viewModel = ViewModelProvider(this)[FriendsViewModel::class.java]

        viewModel.fillUpDatabase()
        viewModel.loadUsersData()


        val id = intent.extras?.getInt(MainActivity.EXTRA_MESSAGE)!!
        viewModel.userLiveData.observe(this, {
            findViewById<TextView>(R.id.userName).text = it[id].name
            findViewById<TextView>(R.id.userStatus).text = resources.getString(R.string.text_post) +
                    it[id].post + resources.getString(R.string.text_age) +
                    it[id].age
            findViewById<ImageView>(R.id.userImage).setImageResource(it[id].photo)
            findViewById<TextView>(R.id.userTitle).text = resources.getString(R.string.text_hobby) +
                    it[id].hobby + resources.getString(R.string.text_email) +
                    it[id].email
            findViewById<TextView>(R.id.detailsTextAbout).text = it[id].description
        })
    }
}
