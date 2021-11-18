package com.example.socialnetworkteo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.ui.friends.FriendsViewModel

class EditListUserActivity : AppCompatActivity() {
    private lateinit var viewModel: FriendsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_list)
        viewModel =
            ViewModelProvider(this)[FriendsViewModel::class.java]
        viewModel.fillUpDatabase()
        viewModel.loadUsersData()

        for (id in 0..(viewModel.userLiveData.value!!.size - 1)) {
            viewModel.userLiveData.observe(this, {
                findViewById<TextView>(
                    resources.getIdentifier(
                        "userEditName$id",
                        "id",
                        packageName
                    )
                ).text = it[id].name
                findViewById<ImageView>(
                    resources.getIdentifier(
                        "editImage$id",
                        "id",
                        packageName
                    )
                ).setImageResource(it[id].photo)
            })
            findViewById<LinearLayout>(
                resources.getIdentifier(
                    "layoutEdit$id",
                    "id",
                    packageName
                )
            ).setOnClickListener { openEditFriend(id) }
        }
    }

    private fun openEditFriend(friendId: Int) {
        val intent = Intent(this, EditUserActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_MESSAGE, friendId)
        startActivity(intent)
        finish()
    }
}