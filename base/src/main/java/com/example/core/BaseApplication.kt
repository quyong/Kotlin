package com.example.core

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull

/**
 * Created by QUYONG on 12/27/20
 */
class BaseApplication : Application() {
    companion object {
        private lateinit var currentApplication: Context

        @NonNull
        fun currentApplication(): Context = currentApplication
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base);
        currentApplication = this;
    }
}