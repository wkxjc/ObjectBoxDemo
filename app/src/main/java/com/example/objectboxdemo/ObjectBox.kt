package com.example.objectboxdemo

import android.content.Context
import io.objectbox.BoxStore

class ObjectBox {
    companion object {
        lateinit var boxStore: BoxStore
        @JvmStatic
        fun init(context: Context) {
            boxStore = MyObjectBox.builder()
                .androidContext(context.applicationContext)
                .build()
        }
    }
}
