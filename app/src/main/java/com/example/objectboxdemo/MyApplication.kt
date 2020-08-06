package com.example.objectboxdemo
import android.app.Application

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }
}
