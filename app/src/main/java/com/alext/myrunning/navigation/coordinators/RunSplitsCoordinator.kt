package com.alext.myrunning.navigation.coordinators

import com.alext.myrunning.navigation.Navigator

class RunSplitsCoordinator(private val navigator: Navigator) {

    fun start() {
        navigator.showRunSplitsFragment()

    }
}