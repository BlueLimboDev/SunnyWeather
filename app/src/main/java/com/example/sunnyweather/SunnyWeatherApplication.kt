package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication:Application() {

    companion object{
        @SuppressLint("StartFieldLeak")
        lateinit var context: Context
        const val TOKEN = "IbxcHZ0d74RhJ2gv"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}

