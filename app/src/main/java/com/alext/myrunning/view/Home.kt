package com.alext.myrunning.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alext.myrunning.R
import com.alext.myrunning.utils.navigator
import com.alext.myrunning.utils.rootFlowCoordinator

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigator.activity = this
        rootFlowCoordinator.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.activity = null
    }

}
