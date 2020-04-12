package com.alext.myrunning.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.alext.myrunning.R
import com.alext.myrunning.utils.getViewModel
import com.alext.myrunning.viewmodel.RunSplitsViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RunSplitsFragment : Fragment() {

    private lateinit var vm: RunSplitsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.run_splits, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = getViewModel()
    }

}
