package com.example.testproject.single.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testproject.R
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {


    val viewModel: DashboardViewModel by viewModels()
    var progressBar : ProgressBar? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_dashboard, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val navController = findNavController()
        val button = view.findViewById<MaterialButton>(R.id.button_search)
        val postsButton = view.findViewById<MaterialButton>(R.id.button_posts)
        val textViewSum = view.findViewById<TextView>(R.id.text_view_sum)
        progressBar = view.findViewById<ProgressBar>(R.id.progressbar_loading)
        textViewSum.text = viewModel.a.toString()
        button.setOnClickListener {
//            navController.navigate(R.id.action_fragment_dashboard_to_fragment_search)
            viewModel.a++
            textViewSum.text = viewModel.a.toString()
        }
        postsButton.setOnClickListener(){
            navController.navigate(R.id.action_fragment_dashboard_to_fragment_posts)
        }
    }


}
