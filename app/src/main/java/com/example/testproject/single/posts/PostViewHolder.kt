package com.example.testproject.single.posts


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import com.example.testproject.task.Task
import com.google.android.material.textview.MaterialTextView
import retrofit2.Response


class PostAdapter(var postsList: List<PostResponse>,val onClick: (PostResponse) -> Unit) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
         val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_view, parent, false)
        return PostViewHolder(view)
    }
    override fun getItemCount(): Int {
        var a = postsList.size
        return a
    }



    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

            holder.bind(postsList.get(position), position)

    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val titleTextView = itemView.findViewById<MaterialTextView>(R.id.post_title)
        private val idTextView = itemView.findViewById<MaterialTextView>(R.id.post_id)
        fun bind(postResponse: PostResponse ,  position: Int) {

            titleTextView.text = postResponse.title.toString()
            idTextView.text = postResponse.id.toString()
            itemView.setOnClickListener {
                onClick(postResponse)
                true
            }
        }

    }
}

