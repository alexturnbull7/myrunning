package com.alext.myrunning.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alext.myrunning.BaseApplication
import com.alext.myrunning.navigation.Navigator
import com.alext.myrunning.navigation.coordinators.RootFlowCoordinator

val Fragment.application
    get() = requireActivity().application as BaseApplication

val Fragment.viewModelFactory: ViewModelProvider.Factory
    get() = application.viewModelFactory


val Activity.navigator: Navigator
    get() = (application as BaseApplication).viewModelFactory.navigator

val Activity.rootFlowCoordinator: RootFlowCoordinator
    get() = (application as BaseApplication).viewModelFactory.rootCoordinator



inline fun <reified viewModel : ViewModel> Fragment.getViewModel(): viewModel {
    return ViewModelProvider(this, application.viewModelFactory)[viewModel::class.java]
}