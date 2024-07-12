package com.example.testproject.single.users

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testproject.R
import com.example.testproject.network.model.UserResponse
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users){
    val viewModel: UserViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var postId = view.findViewById<MaterialTextView>(R.id.post_id)
        val usersNameTextView = view.findViewById<MaterialTextView>(R.id.users_name)
        val usernameTextView = view.findViewById<MaterialTextView>(R.id.username)
        val userEmailTextView = view.findViewById<MaterialTextView>(R.id.user_email)
        val usersWebsiteTextView = view.findViewById<MaterialTextView>(R.id.user_website)
        val userAddressTextView = view.findViewById<MaterialTextView>(R.id.user_address)
        val usersCompanyTextView = view.findViewById<MaterialTextView>(R.id.user_company)
        val usersNumberTextView = view.findViewById<MaterialTextView>(R.id.user_number)

        var postTitle = view.findViewById<MaterialTextView>(R.id.post_title)
        var userId= requireArguments().getString("USER_ID")
        userId?.let {
            viewModel.getUser(userId)
        }
        viewModel.user.observe(viewLifecycleOwner){
            usersNameTextView.text = it.name
            usernameTextView.text = it.username
            userEmailTextView.text = it.email
            usersWebsiteTextView.text = it.website
            userAddressTextView.text = it.address?.city + ", st" + it.address?.street + "zip : " + it.address?.zipcode
            usersCompanyTextView.text = it.company?.name + " - " + it.company?.bs + " , " + it.company?.catchPhrase
            usersNumberTextView.text = it.phone
        }
        viewModel.loading.observe(viewLifecycleOwner){
            val progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
            progressBar.isVisible = it
        }


        postId?.setOnClickListener(){
            navigateToUsersFragmnet()
        }
        postTitle?.setOnClickListener(){
            navigateToUsersFragmnet()
        }
    }
    fun navigateToUsersFragmnet(){
        findNavController().navigate(R.id.action_fragment_post_to_fragment_users)
    }
    fun showUser(user : UserResponse) {

    }
}