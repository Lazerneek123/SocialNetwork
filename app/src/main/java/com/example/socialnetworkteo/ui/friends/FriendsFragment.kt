package com.example.socialnetworkteo.ui.friends

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
import androidx.lifecycle.lifecycleScope
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.activities.MainActivity
import com.example.socialnetworkteo.databinding.FragmentFriendsBinding
import com.example.socialnetworkteo.models.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FriendsFragment : Fragment() {

    private lateinit var viewModel: FriendsViewModel
    private var binding: FragmentFriendsBinding? = null
    private var root: View? = null
    private var idUser = 0
    var packageName: String? = null

    @SuppressLint("CutPasteId", "InflateParams")
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

        var countUsers = 0


        lifecycleScope.launch {
            while (countUsers == 0) {
                countUsers = viewModel.getSizeList.value!!
                delay(50)
            }
            countUsers--

            for (id in 0..countUsers) {
                viewModel.userLiveData.observe(viewLifecycleOwner, {
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
                ).setOnClickListener { openFriend(id) }
            }
        }

        lifecycleScope.launch {
            while (true) {
                viewModel.loadUserData(idUser)
                viewModel.userLiveData.observe(viewLifecycleOwner, {
                    root!!.findViewById<TextView>(
                        resources.getIdentifier(
                            "userName$idUser",
                            "id",
                            packageName
                        )
                    ).text = viewModel.user.value!!.name
                })

                delay(500)
            }
        }

        val textView: TextView = binding!!.textFriends
        textView.text = resources.getString(R.string.friends_fragment_inscription)

        return root!!
    }

    private fun openFriend(friendId: Int) {
        (activity as MainActivity).openFriend(friendId)
        idUser = friendId
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