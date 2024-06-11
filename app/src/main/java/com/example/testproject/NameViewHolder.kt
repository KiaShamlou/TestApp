package com.example.testproject

import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class NameAdapter(val nameList: List<Person>) :
  RecyclerView.Adapter<NameAdapter.NameViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
    //here we indicate that this list should show list_item
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.list_item, parent, false)
    return NameViewHolder(view)
  }

  override fun getItemCount(): Int {
    return nameList.size
  }

  override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
    holder.bind(nameList[position], position)
  }

  inner class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    private val nameText = itemView.findViewById<TextView>(R.id.name_text)
    private val image = itemView.findViewById<AppCompatImageView>(R.id.imageView1)
    //bind -> entering data to view
    //each we bind new data to an item
    //we should insert data we have (name color...) to the views we have nameText, image
    fun bind(person: Person, position: Int){
      nameText.text = person.name
      image.setColorFilter(ContextCompat.getColor(itemView.context, person.color))
      if(person.isNameGreen){
        nameText.setTextColor(ContextCompat.getColor(itemView.context, R.color.green))
      }else{
        nameText.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
      }
      itemView.setOnClickListener {
        Toast.makeText(itemView.context, position.toString(), Toast.LENGTH_LONG).show()
        var newList = nameList.map {
          it.isNameGreen = false
          it
        }
        newList[position].isNameGreen = true
        //notifies data changed, hey recycler view I updated the list, render it again
        notifyDataSetChanged()
      }
    }
  }
}
