package com.example.socialnetworkteo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.socialnetworkteo.R
import com.example.socialnetworkteo.activities.MainActivity
import com.example.socialnetworkteo.databinding.ItemUserBinding
import com.example.socialnetworkteo.models.User

class UserAdapter(activity: FragmentActivity) :
    ListAdapter<User, UserAdapter.ItemViewHolder>(object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
    }) {

    private var activityFriendsFragment: FragmentActivity = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_user, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.onClick(position)
        //holder.onLongClick(0)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnUserClick {
        private var binding: ItemUserBinding = ItemUserBinding.bind(itemView)
        private val userName: TextView = binding.userName
        private val userOnlineStatus: TextView = binding.userOnline
        private val userImageView: ImageView = binding.userImage

        override fun onClick(userId: Int) {
            itemView.setOnClickListener {
                (activityFriendsFragment as MainActivity).openFriendMainActivity(userId)
            }
        }

        override fun onLongClick(userId: Int) {
            /*itemView.setOnLongClickListener {
                (activityFriendsFragment as MainActivity).openFriendMainActivity(userId)
                true
            }*/
        }

        fun bind(item: User) {
            userName.text = item.name
            userOnlineStatus.text = item.online
            userOnlineStatus.setColor(item)
            userImageView.setImageResource(item.photo)
        }
    }

    private fun TextView.setColor(it: User) {
        if (it.online != "Online") {
            this.setTextColor(Color.rgb(255, 0, 10))
        }
    }
}

