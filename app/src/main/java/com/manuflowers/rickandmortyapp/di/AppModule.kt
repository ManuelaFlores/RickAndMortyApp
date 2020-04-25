package com.manuflowers.rickandmortyapp.di

import com.manuflowers.rickandmortyapp.ui.base.ActivityRetriever
import com.manuflowers.rickandmortyapp.ui.base.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}