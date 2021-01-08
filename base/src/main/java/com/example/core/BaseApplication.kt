package com.example.core

import android.app.Application
import android.content.Context

/**
 * Created by QUYONG on 12/27/20
 */
class BaseApplication : Application() {
    companion object {
        @get:JvmName("currentApplication")
        @JvmStatic
        lateinit var currentApplication: Context
            private set
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base);
        currentApplication = this
    }
}