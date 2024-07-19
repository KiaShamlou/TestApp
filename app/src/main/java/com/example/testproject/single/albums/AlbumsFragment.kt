package com.example.testproject.single.albums

import com.example.testproject.single.posts.PostAdapter
import com.example.testproject.single.posts.PostClickedCallBack

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
import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.PostResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlbumsFragment : Fragment(R.layout.fragment_album) {
    var albumAdapter: AlbumAdapter? = null
    val viewModel: AlbumsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
        var userId= requireArguments().getString("USER_ID")
        userId?.let {
            viewModel.getAlbums(userId)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.albums.collectLatest {
                    when(it){
                        is Resource.Success -> {
                            showAlbumsList(it.data)
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

//    fun navigateToUsersFragmnet(user: PostResponse) {
//        val bundle = Bundle()
//        bundle.putString("POST_ID",user.id.toString())
//        findNavController().navigate(R.id.action_fragment_post_to_fragment_comments, bundle)
//    }

    fun showAlbumsList(albumsList: List<AlbumResponse>) {
        var recyclerView = view?.findViewById<RecyclerView>(R.id.album_recycler_view)
        albumAdapter = AlbumAdapter(albumsList)
        recyclerView?.adapter = albumAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}
