package com.example.testproject.single.users

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.network.model.UserResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users_list) {
    var userAdapter: UserAdapter? = null
    val viewModel: UsersViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.usersList.observe(viewLifecycleOwner) {
            showUsersList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            val progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
            progressBar.isVisible = it
        }

    }
//
//    fun navigateToUsersFragmnet(user: PostResponse) {
//        val bundle = Bundle()
//        bundle.putString("POST_ID",user.id.toString())
//        findNavController().navigate(R.id.action_fragment_post_to_fragment_comments, bundle)
//    }

    fun showUsersList(usersList: List<UserResponse>) {
        var recyclerView = view?.findViewById<RecyclerView>(R.id.users_recyclerview)
        userAdapter = UserAdapter(usersList)
        recyclerView?.adapter = userAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}
