package com.diegoalvis.sandbox.di

import com.diegoalvis.sandbox.data.DummyRepository
import com.diegoalvis.sandbox.data.local.AppDatabase
import com.diegoalvis.sandbox.data.local.getDb
import com.diegoalvis.sandbox.data.network.createRetrofitClient
import com.diegoalvis.sandbox.feature.ui.DummyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { createRetrofitClient() }
    single { getDb<AppDatabase>(androidContext(), AppDatabase.DATABASE_NAME).dummyDao() }
    single { DummyRepository(get(), get()) }
    viewModel { DummyViewModel(get()) }
}