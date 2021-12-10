package com.example.socialnetworkteo.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.activities.MainActivity
import com.example.socialnetworkteo.databinding.FragmentFriendsBinding
import com.example.socialnetworkteo.models.User
import com.example.socialnetworkteo.viewModel.FriendsViewModel

class FriendsFragment : Fragment() {

    private lateinit var viewModel: FriendsViewModel
    private var binding: FragmentFriendsBinding? = null
    private var root: View? = null
    private var packageName: String? = null


    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[FriendsViewModel::class.java]

        root = inflater.inflate(R.layout.fragment_friends, null)
        binding = FragmentFriendsBinding.bind(root!!)
        packageName = activity?.packageName

        viewModel.getAllUsers()

        viewModel.getSizeList().observe(viewLifecycleOwner, {
            val listUserSize = it

            for (id in 0..listUserSize) {
                viewModel.userLiveData().observe(viewLifecycleOwner, { it ->
                    root!!.findViewById<TextView>(
                        resources.getIdentifier(
                            "userName$id",
                            "id",
                            packageName
                        )
                    ).text = it[id].name

                    root!!.findViewById<TextView>(
                        resources.getIdentifier(
                            "userOnline$id",
                            "id",
                            packageName
                        )
                    ).text = it[id].online
                    root!!.findViewById<ImageView>(
                        resources.getIdentifier(
                            "userImage$id",
                            "id",
                            packageName
                        )
                    ).setImageResource(it[id].photo)
                    root!!.findViewById<TextView>(
                        resources.getIdentifier(
                            "userOnline$id",
                            "id",
                            packageName
                        )
                    ).setColor(it[id])

                })
                root!!.findViewById<LinearLayout>(
                    resources.getIdentifier(
                        "layout$id",
                        "id",
                        packageName
                    )
                ).setOnClickListener {
                    openFriend(id)
                }
            }
            })

        val textView: TextView = binding!!.textFriends
        textView.text = resources.getString(R.string.friends_fragment_inscription)

        return root!!
    }

    private fun openFriend(friendId: Int) {
        (activity as MainActivity).openFriend(friendId)
        (activity as MainActivity).recreate()

    }

    private fun TextView.setColor(it: User) {
        if (it.online != "Online") {
            this.setTextColor(Color.rgb(255, 0, 10))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}