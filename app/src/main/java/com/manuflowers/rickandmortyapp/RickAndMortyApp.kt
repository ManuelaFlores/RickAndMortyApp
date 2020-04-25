package com.manuflowers.rickandmortyapp

import android.app.Application
import com.manuflowers.rickandmortyapp.di.appModule
import com.manuflowers.rickandmortyapp.di.networkModule
import com.manuflowers.rickandmortyapp.ui.base.DefaultCurrentActivityListener
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApp: Application() {

    val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApp)
            modules(listOf(networkModule, appModule))
        }
        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
    }


}