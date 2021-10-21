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
import com.example.socialnetworkteo.MainActivity
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.databinding.FragmentFriendsBinding
import com.example.socialnetworkteo.model.UserData

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

        val root: View = inflater.inflate(R.layout.fragment_friends, null)
        _binding = FragmentFriendsBinding.bind(root)
        val user1: LinearLayout = _binding!!.layout1
        val user2: LinearLayout = _binding!!.layout2
        val user3: LinearLayout = _binding!!.layout3
        val user4: LinearLayout = _binding!!.layout4
        val user5: LinearLayout = _binding!!.layout5
        val user6: LinearLayout = _binding!!.layout6
        val user7: LinearLayout = _binding!!.layout7

        user1.setOnClickListener { openFriend(0) }
        user2.setOnClickListener { openFriend(1) }
        user3.setOnClickListener { openFriend(2) }
        user4.setOnClickListener { openFriend(3) }
        user5.setOnClickListener { openFriend(4) }
        user6.setOnClickListener { openFriend(5) }
        user7.setOnClickListener { openFriend(6) }

        val friend1Image : ImageView = _binding!!.userImage1
        val nameFriend1 : TextView = _binding!!.userName1
        val onlineStatusFriend1 : TextView = _binding!!.userOnline1
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend1.text = it.userList.value!![0].name
            onlineStatusFriend1.text = it.userList.value!![0].online
            friend1Image.setImageResource(it.userList.value!![0].photo)
            0.setColor(onlineStatusFriend1, it)
        })

        val friend2Image : ImageView = _binding!!.userImage2
        val nameFriend2 : TextView = _binding!!.userName2
        val onlineStatusFriend2 : TextView = _binding!!.userOnline2
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend2.text = it.userList.value!![1].name
            onlineStatusFriend2.text = it.userList.value!![1].online
            friend2Image.setImageResource(it.userList.value!![1].photo)
            1.setColor(onlineStatusFriend2, it)
        })


        val friend3Image : ImageView = _binding!!.userImage3
        val nameFriend3 : TextView = _binding!!.userName3
        val onlineStatusFriend3 : TextView = _binding!!.userOnline3
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend3.text = it.userList.value!![2].name
            onlineStatusFriend3.text = it.userList.value!![2].online
            friend3Image.setImageResource(it.userList.value!![2].photo)
            2.setColor(onlineStatusFriend3, it)
        })

        val friend4Image : ImageView = _binding!!.userImage4
        val nameFriend4 : TextView = _binding!!.userName4
        val onlineStatusFriend4 : TextView = _binding!!.userOnline4
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend4.text = it.userList.value!![3].name
            onlineStatusFriend4.text = it.userList.value!![3].online
            friend4Image.setImageResource(it.userList.value!![3].photo)
            3.setColor(onlineStatusFriend4, it)
        })

        val friend5Image : ImageView = _binding!!.userImage5
        val nameFriend5 : TextView = _binding!!.userName5
        val onlineStatusFriend5 : TextView = _binding!!.userOnline5
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend5.text = it.userList.value!![4].name
            onlineStatusFriend5.text = it.userList.value!![4].online
            friend5Image.setImageResource(it.userList.value!![4].photo)
            4.setColor(onlineStatusFriend5, it)
        })

        val friend6Image : ImageView = _binding!!.userImage6
        val nameFriend6 : TextView = _binding!!.userName6
        val onlineStatusFriend6 : TextView = _binding!!.userOnline6
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend6.text = it.userList.value!![5].name
            onlineStatusFriend6.text = it.userList.value!![5].online
            friend6Image.setImageResource(it.userList.value!![5].photo)
            5.setColor(onlineStatusFriend6, it)
        })

        val friend7Image : ImageView = _binding!!.userImage7
        val nameFriend7 : TextView = _binding!!.userName7
        val onlineStatusFriend7 : TextView = _binding!!.userOnline7
        friendsViewModel.userData.observe(viewLifecycleOwner, {
            nameFriend7.text = it.userList.value!![6].name
            onlineStatusFriend7.text = it.userList.value!![6].online
            friend7Image.setImageResource(it.userList.value!![6].photo)
            6.setColor(onlineStatusFriend7, it)
        })

        val textView: TextView = _binding!!.textFriends
        friendsViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })


        return root
    }

    private fun openFriend(friendId: Int) {
        (activity as MainActivity).openFriend(friendId)
    }


    private fun Int.setColor(view: TextView, it: UserData) {
        if(it.userList.value!![this].online != "Online"){
            view.setTextColor(Color.rgb(255, 0, 10))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}