package com.example.socialnetworkteo.ui.friends

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.databinding.FragmentFriendsBinding

class FriendsFragment : Fragment() {

    private lateinit var friendsViewModel: FriendsViewModel
    private var _binding: FragmentFriendsBinding? = null

    @SuppressLint("CutPasteId", "InflateParams")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        friendsViewModel =
                ViewModelProvider(this).get(FriendsViewModel::class.java)

        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        val root: View = inflater.inflate(R.layout.fragment_friends, null)

        val friend1Image : ImageView = root.findViewById(R.id.userImage1)
        val nameFriend1 : TextView = root.findViewById(R.id.userName1)
        val onlineStatusFriend1 : TextView = root.findViewById(R.id.userOnline1)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend1.text = it.userList[0].name.value
            onlineStatusFriend1.text =it.userList[0].online.value
            friend1Image.setImageResource(it.userList[0].photo.value!!)
            if(it.userList[0].online.value != "Online"){
                onlineStatusFriend1.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val friend2Image : ImageView = root.findViewById(R.id.userImage2)
        val nameFriend2 : TextView = root.findViewById(R.id.userName2)
        val onlineStatusFriend2 : TextView = root.findViewById(R.id.userOnline2)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend2.text = it.userList[1].name.value
            onlineStatusFriend2.text =it.userList[1].online.value
            friend2Image.setImageResource(it.userList[1].photo.value!!)
            if(it.userList[1].online.value != "Online"){
                onlineStatusFriend2.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val friend3Image : ImageView = root.findViewById(R.id.userImage3)
        val nameFriend3 : TextView = root.findViewById(R.id.userName3)
        val onlineStatusFriend3 : TextView = root.findViewById(R.id.userOnline3)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend3.text = it.userList[2].name.value
            onlineStatusFriend3.text =it.userList[2].online.value
            friend3Image.setImageResource(it.userList[2].photo.value!!)
            if(it.userList[2].online.value != "Online"){
                onlineStatusFriend3.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val friend4Image : ImageView = root.findViewById(R.id.userImage4)
        val nameFriend4 : TextView = root.findViewById(R.id.userName4)
        val onlineStatusFriend4 : TextView = root.findViewById(R.id.userOnline4)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend4.text = it.userList[3].name.value
            onlineStatusFriend4.text =it.userList[3].online.value
            friend4Image.setImageResource(it.userList[3].photo.value!!)
            if(it.userList[3].online.value != "Online"){
                onlineStatusFriend4.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val friend5Image : ImageView = root.findViewById(R.id.userImage5)
        val nameFriend5 : TextView = root.findViewById(R.id.userName5)
        val onlineStatusFriend5 : TextView = root.findViewById(R.id.userOnline5)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend5.text = it.userList[4].name.value
            onlineStatusFriend5.text =it.userList[4].online.value
            friend5Image.setImageResource(it.userList[4].photo.value!!)
            if(it.userList[4].online.value != "Online"){
                onlineStatusFriend5.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val friend6Image : ImageView = root.findViewById(R.id.userImage6)
        val nameFriend6 : TextView = root.findViewById(R.id.userName6)
        val onlineStatusFriend6 : TextView = root.findViewById(R.id.userOnline6)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend6.text = it.userList[5].name.value
            onlineStatusFriend6.text =it.userList[5].online.value
            friend6Image.setImageResource(it.userList[5].photo.value!!)
            if(it.userList[5].online.value != "Online"){
                onlineStatusFriend6.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val friend7Image : ImageView = root.findViewById(R.id.userImage7)
        val nameFriend7 : TextView = root.findViewById(R.id.userName7)
        val onlineStatusFriend7 : TextView = root.findViewById(R.id.userOnline7)
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend7.text = it.userList[6].name.value
            onlineStatusFriend7.text =it.userList[6].online.value
            friend7Image.setImageResource(it.userList[6].photo.value!!)
            if(it.userList[6].online.value != "Online"){
                onlineStatusFriend7.setTextColor(Color.rgb(255, 0, 10))
            }
        })

        val textView: TextView = root.findViewById(R.id.text_friends)
        friendsViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}