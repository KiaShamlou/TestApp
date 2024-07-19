package com.example.testproject.single.comments

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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.Resource
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.single.posts.PostAdapter
import com.example.testproject.single.posts.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CommentsFragment : Fragment(R.layout.fragment_comments) {
    var commentAdapter: CommentAdapter? = null
    val viewModel: CommentsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
        var postId= requireArguments().getString("POST_ID")
        postId?.let {
            viewModel.getComments(postId)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.comments.collectLatest {
                    when(it){
                        is Resource.Success -> {
                            showCommentsList(it.data)
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

    fun navigateToUsersFragmnet(comment: CommentResponse) {
        findNavController().navigate(R.id.action_fragment_post_to_fragment_users)
    }

    fun showCommentsList(commentsList: List<CommentResponse>) {
        var recyclerView = view?.findViewById<RecyclerView>(R.id.comments_recycler_view)
        commentAdapter = CommentAdapter(commentsList, ::navigateToUsersFragmnet)
        recyclerView?.adapter = commentAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}
