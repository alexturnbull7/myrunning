package com.alext.myrunning.navigation.coordinators

class RootFlowCoordinator {

    lateinit var runSplitsCoordinator: RunSplitsCoordinator

    init {

    }

    fun start() {
        runSplitsCoordinator.start()
    }
}