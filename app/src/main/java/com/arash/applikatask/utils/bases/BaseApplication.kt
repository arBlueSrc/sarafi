package com.arash.applikatask.utils.bases

import android.app.Application
import com.arash.applikatask.di.appModules
import com.arash.applikatask.di.networkModules
import com.arash.applikatask.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@BaseApplication)
            modules(appModules, networkModules, viewModelModules)
        }
    }
}