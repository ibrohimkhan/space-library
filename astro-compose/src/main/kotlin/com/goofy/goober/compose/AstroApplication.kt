package com.goofy.goober.compose

import android.app.Application
import com.goofy.goober.common
import com.goofy.goober.compose.viewmodel.ImageSearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class AstroApplication : Application() {

    private val appModule = module {
        viewModel { ImageSearchViewModel(astroInteractor = get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AstroApplication)
            modules(common)
            modules(appModule)
        }
    }
}
