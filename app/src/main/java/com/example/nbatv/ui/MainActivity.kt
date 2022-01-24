package com.example.nbatv.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import com.example.nbatv.Team
import com.example.nbatv.TeamAdapter
import kotlinx.android.synthetic.main.teams_fragment.*
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //test data for teams, checking if recyclerView adapter works
//        val teamsTest = listOf<Team>(
//            Team(1, "Toronto Raptors", 45, 55),
//            Team(2, "Boston Celtics", 34, 23),
//            Team(3, "Miami Heat", 32, 34),
//        )
//
//        recyclerViewTeams.layoutManager = LinearLayoutManager(this)
//        recyclerViewTeams.adapter = TeamAdapter(teamsTest)
    }
}