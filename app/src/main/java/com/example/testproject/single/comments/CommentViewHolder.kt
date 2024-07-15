package com.example.testproject.single.comments


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import com.example.testproject.task.Task
import com.google.android.material.textview.MaterialTextView
import retrofit2.Response


class CommentAdapter(var commentsList: List<CommentResponse>,val onClick: (CommentResponse) -> Unit) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_view, parent, false)
        return CommentViewHolder(view)
    }
    override fun getItemCount(): Int {
        var a = commentsList.size
        return a
    }



    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        holder.bind(commentsList.get(position), position)

    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val emailTextView = itemView.findViewById<MaterialTextView>(R.id.email_text_view)
        private val commentTextView = itemView.findViewById<MaterialTextView>(R.id.comment_text_view)
        fun bind(commentResponse: CommentResponse ,  position: Int) {

            emailTextView.text = commentResponse.email
            commentTextView.text = commentResponse.body

            itemView.setOnClickListener {
                onClick(commentResponse)
                true
            }
        }

    }
}


