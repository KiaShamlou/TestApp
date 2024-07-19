package com.example.testproject.single.albums


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import com.google.android.material.textview.MaterialTextView

class AlbumAdapter(var albumsList: List<AlbumResponse>) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }
    override fun getItemCount(): Int {
        var a = albumsList.size
        return a
    }



    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {

        holder.bind(albumsList.get(position), position)

    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val titleTextView = itemView.findViewById<MaterialTextView>(R.id.album_title_text_view)
        private val idTextView = itemView.findViewById<MaterialTextView>(R.id.album_id_text_view)
        fun bind(albumResponse: AlbumResponse ,  position: Int) {

            idTextView.text = albumResponse.id.toString()
            titleTextView.text = albumResponse.title
        }

    }
}


