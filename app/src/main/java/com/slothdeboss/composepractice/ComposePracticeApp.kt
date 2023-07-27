package com.slothdeboss.composepractice

import android.app.Application
import com.slothdeboss.composepractice.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposePracticeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ComposePracticeApp)
            modules(appModules)
        }
    }
}
