package com.example.testproject.single.posts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.Resource
import com.example.testproject.network.model.PostResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragmet_posts) {
    var postAdapter: PostAdapter? = null
    val viewModel: PostsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.posts.collectLatest {
                    when(it){
                        is Resource.Success -> {
                            showPostsList(it.data)
                            progressBar.isVisible = false
                        }
                        is Resource.Error -> {

                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                            progressBar.isVisible = false
                        }

                        is Resource.Loading -> {
                            progressBar.isVisible = true
                        }
                    }
                }
            }
        }
    }

    fun navigateToUsersFragmnet(user: PostResponse) {
        val bundle = Bundle()
        bundle.putString("POST_ID",user.id.toString())
        findNavController().navigate(R.id.action_fragment_post_to_fragment_comments, bundle)
    }

    fun showPostsList(postsList: List<PostResponse>) {
        var recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view_posts)
        postAdapter = PostAdapter(postsList, object : PostClickedCallBack{
            override fun postClicked(post: PostResponse) {
                navigateToUsersFragmnet(post)
            }
        })
        recyclerView?.adapter = postAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}
