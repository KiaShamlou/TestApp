package com.example.testproject.single.users


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.model.UserResponse
import com.google.android.material.textview.MaterialTextView


class UserAdapter(var UsersList: List<UserResponse>, val onClick: (UserResponse) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        var a = UsersList.size
        return a
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(UsersList.get(position), position)
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView.findViewById<MaterialTextView>(R.id.post_title)
        private val idTextView = itemView.findViewById<MaterialTextView>(R.id.post_id)
        fun bind(userResponse: UserResponse, position: Int) {

            titleTextView.text = userResponse.name
            idTextView.text = userResponse.id.toString()
            itemView.setOnClickListener {
                onClick(userResponse)
                true
            }

        }
    }
}

