package com.alext.myrunning

import AppViewModelFactory
import android.app.Application
import com.alext.myrunning.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {

    val viewModelFactory by lazy {
        AppViewModelFactory(this)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(listOf(applicationModule))
        }
    }
}
