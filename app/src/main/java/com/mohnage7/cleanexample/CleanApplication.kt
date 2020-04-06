package com.mohnage7.cleanexample

import android.app.Application
import com.integrant.timeinrange.presentation.di.dataBaseModule
import com.mohnage7.cleanexample.di.networkModule
import com.mohnage7.cleanexample.di.postsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CleanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinInjection()
    }

    private fun startKoinInjection() {
        startKoin {
            androidContext(this@CleanApplication)
            modules(listOf(networkModule, dataBaseModule, postsModule))
        }
    }
}