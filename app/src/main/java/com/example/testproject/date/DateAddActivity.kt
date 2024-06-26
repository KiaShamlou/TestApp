package com.example.testproject.date

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.MainActivity
import com.example.testproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DateAddActivity : AppCompatActivity() {
    var recievedDateList = arrayListOf<Date>()
    var addDateAdapter : DateAddAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_date_add)
        intent.getParcelableArrayListExtra<Date>("dateList")?.forEach {
            recievedDateList.add(it)
        }
        val button = findViewById<FloatingActionButton>(R.id.floating_action_but_add_date)
        button.setOnClickListener() {
            navigateToDateAdd()
        }
        showDatesList(recievedDateList.toMutableList())
    }

    fun navigateToDateAdd() {
        var intentt = Intent(this, AddDateDialogActivity::class.java)
        val bundle = Bundle()
        startActivityForResult(intentt, 106)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 106 && resultCode == RESULT_OK) {
            val addedDate = data?.getParcelableExtra<Date>("ADDED_DATE")
            if (addedDate != null) {
                    addDateAdapter?.addDate(addedDate)
            }
        }
    }


    fun showDatesList(recievedDateList: MutableList<Date>) {
        var recyclerView = this.findViewById<RecyclerView>(R.id.date_recycler_view)
        recievedDateList.toMutableList()
        addDateAdapter = DateAddAdapter(recievedDateList,::setDateResult)
        recyclerView.adapter = addDateAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    fun setDateResult (list:List<Date>){
        var intent = Intent(this, MainActivity::class.java)
        val newList = ArrayList<Date>()
        list.forEach {
            newList.add(it)
        }
        intent.putParcelableArrayListExtra("DATE_LIST" , newList)
        setResult(RESULT_OK, intent)
//        finish()
    }
}
