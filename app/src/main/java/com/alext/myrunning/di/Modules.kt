package com.alext.myrunning.di

import android.content.Context
import android.content.SharedPreferences
import com.alext.myrunning.navigation.Navigator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val applicationModule = module(override = true) {
    single<SharedPreferences> { androidContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE) }
    single { Navigator() }
}