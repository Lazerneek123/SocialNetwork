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
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.activities.MainActivity
import com.example.socialnetworkteo.databinding.FragmentFriendsBinding
import com.example.socialnetworkteo.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FriendsFragment : Fragment() {

    private lateinit var viewModel: FriendsViewModel
    private var binding: FragmentFriendsBinding? = null

    @SuppressLint("CutPasteId", "InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[FriendsViewModel::class.java]

        viewModel.fillUpDatabase()
        viewModel.loadUsersData()

        val root: View = inflater.inflate(R.layout.fragment_friends, null)
        binding = FragmentFriendsBinding.bind(root)

        val packageName = activity?.packageName
        for (id in 0..(viewModel.userLiveData.value!!.size - 1)) {
            viewModel.userLiveData.observe(viewLifecycleOwner, {
                root.findViewById<TextView>(
                    resources.getIdentifier(
                        "userName$id",
                        "id",
                        packageName
                    )
                ).text = it[id].name
                root.findViewById<TextView>(
                    resources.getIdentifier(
                        "userOnline$id",
                        "id",
                        packageName
                    )
                ).text = it[id].online
                root.findViewById<ImageView>(
                    resources.getIdentifier(
                        "userImage$id",
                        "id",
                        packageName
                    )
                ).setImageResource(it[id].photo)
                root.findViewById<TextView>(
                    resources.getIdentifier(
                        "userOnline$id",
                        "id",
                        packageName
                    )
                ).setColor(it[id])
            })
            root.findViewById<LinearLayout>(
                resources.getIdentifier(
                    "layout$id",
                    "id",
                    packageName
                )
            ).setOnClickListener { openFriend(id) }
        }

        val textView: TextView = binding!!.textFriends
        textView.text = resources.getString(R.string.friends_fragment_inscription)

        return root
    }

    private fun openFriend(friendId: Int) {
        (activity as MainActivity).openFriend(friendId)
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