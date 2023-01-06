package com.example.kotlinmanualdi

import android.app.Application

class RandomizeApplication: Application() {
    val applicationContainer = ApplicationContainer()

    override fun onCreate() {
        super.onCreate()
    }
}