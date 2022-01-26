package com.example.nbatv.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.nbatv.R
//import com.example.nbatv.di.nbaTeamModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nbatv.R.layout.activity_main)
        //start koin
//        startKoin{
//            androidLogger()
//            androidContext(this@MainActivity)
//            modules(nbaTeamModule)
//        }
    }
}