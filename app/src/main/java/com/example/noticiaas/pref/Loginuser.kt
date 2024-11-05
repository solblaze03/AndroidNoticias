package com.example.noticiaas.pref

import android.app.Application

class Loginuser : Application() {

    companion object{
        lateinit var prefs : Sharedpref
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Sharedpref(applicationContext)
    }

}