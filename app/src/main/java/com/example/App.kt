package com.example

import android.app.Application
import com.example.daggerpackage.component.AppComponent
import com.example.daggerpackage.component.DaggerAppComponent


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .build()
    }
}

lateinit var component: AppComponent