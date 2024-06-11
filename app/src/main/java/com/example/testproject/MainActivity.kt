package com.example.testproject

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //String name = "kia";
        var name = "kia"
        val button = this.findViewById<AppCompatButton>(R.id.profile_button)
        var edittext = this.findViewById<AppCompatEditText>(R.id.edittext)

        button.setOnClickListener {

            Toast.makeText(this, edittext.text, Toast.LENGTH_LONG).show()
        }
        button.text = "kianoosh"


        var text = this.findViewById<TextView>(R.id.bio_text)
        text.text = "this is a sample text"


//        edittext.doOnTextChanged { text, start, before, count ->
////            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
//
//        }

        var recyclerView = this.findViewById<RecyclerView>(R.id.recycler_view)
        var namesList = listOf(
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
            Person("keivan", R.color.purple),
            Person("kia", R.color.black),
            Person("kave", R.color.white),
            Person("lia", R.color.orange),
            Person("via", R.color.green),
        )
        //NameAdapter adapter = new NameAdapter(namesList)
        var adapter = NameAdapter(namesList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}
