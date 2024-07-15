package com.example.testproject.single.posts

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.model.PostResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragmet_posts) {
    var postAdapter: PostAdapter? = null
    val viewModel: PostsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner) {
            showPostsList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            val progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
            progressBar.isVisible = it
        }

    }

    fun navigateToUsersFragmnet(user: PostResponse) {
        val bundle = Bundle()
        bundle.putString("POST_ID",user.id.toString())
        findNavController().navigate(R.id.action_fragment_post_to_fragment_comments, bundle)
    }

    fun showPostsList(postsList: List<PostResponse>) {
        var recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view_posts)
        postAdapter = PostAdapter(postsList, ::navigateToUsersFragmnet)
        recyclerView?.adapter = postAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}
