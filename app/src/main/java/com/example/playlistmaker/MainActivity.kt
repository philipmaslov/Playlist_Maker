package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById<Button>(R.id.search_btn)
        val libraryBtn = findViewById<Button>(R.id.library_btn)
        val settingsBtn = findViewById<Button>(R.id.settings_btn)

        settingsBtn.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }

        searchBtn.setOnClickListener {
//            val searchIntent = Intent(this, SearchActivity::class.java)
            val searchIntent = Intent(this, NothingActivity::class.java)
            startActivity(searchIntent)
        }

        libraryBtn.setOnClickListener {
//            val libraryIntent = Intent(this, LibraryActivity::class.java)
            val libraryIntent = Intent(this, NothingActivity::class.java)
            startActivity(libraryIntent)
        }
    }
}