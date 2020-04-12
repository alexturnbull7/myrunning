package com.alext.myrunning.navigation

import androidx.fragment.app.FragmentActivity
import com.alext.myrunning.R
import com.alext.myrunning.view.RunSplitsFragment

class Navigator {

    var activity : FragmentActivity? = null

    fun showRunSplitsFragment(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragmentContainer, RunSplitsFragment())
            ?.commit()
    }
}