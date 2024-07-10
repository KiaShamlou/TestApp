package com.example.testproject.single.posts

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.data.DateManager
import com.example.testproject.date.DateAdapter
import com.example.testproject.network.ApiInterface
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.LaptopResponse
import com.example.testproject.network.model.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsFragment : Fragment(R.layout.fragmet_posts){

    var progressBar : ProgressBar? = null
    var postAdapter: PostAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
        getApiInterface()
    }
    private fun getApiInterface() {
        progressBar?.isVisible = true
        val retrofit = RetrofitInstance.getInstance().create(ApiInterface::class.java)


        val call = retrofit.getPosts()
        call.enqueue(object : Callback<List<PostResponse>> {
            override fun onResponse(call: Call<List<PostResponse>>, response: Response<List<PostResponse>>) {
                if (response.isSuccessful && response.body() != null) {
                    Toast.makeText(requireContext(), response.body()?.size.toString()?:"", Toast.LENGTH_LONG).show()
                    showPostsList(response.body()!!)

                }
                progressBar?.isVisible = false
            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                progressBar?.isVisible = false
            }
        }
        )
    }
    fun showPostsList(postsList :  List<PostResponse>) {
        var recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view_posts)
        //NameAdapter adapter = new NameAdapter(namesList)
        postAdapter = PostAdapter(postsList)
        recyclerView?.adapter = postAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }
}