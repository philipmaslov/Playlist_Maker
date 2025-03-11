package com.example.playlistmaker

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dalvik.system.ApplicationRuntime
import androidx.core.net.toUri

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val shareApp = findViewById<LinearLayout>(R.id.shareAppButton)
        val sendToSuppot = findViewById<LinearLayout>(R.id.writeToSupportButton)
        val showUserPolicy = findViewById<LinearLayout>(R.id.userPolicyButton)
        val backButton = findViewById<ImageView>(R.id.back)

        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        shareApp.setOnClickListener {
            val shareApp = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, getString(R.string.app_link))
            }
            try {
                startActivity(
                    Intent.createChooser(
                        shareApp,
                        shareApp.getStringExtra(Intent.EXTRA_TEXT)
                    )
                )
            } catch (e: Exception) {
                // TODO: Добавить какой-нибудь вывод об ошибке
            }
        }

        sendToSuppot.setOnClickListener {
            val supportRequest = Intent(Intent.ACTION_SENDTO).apply {
                data = ("mailto:${getString(R.string.my_email)}" +
                        "?subject=${getString(R.string.support_subject)}" +
                        "&body=${getString(R.string.support_message)}").toUri()
            }

            try {
                startActivity(
                    Intent.createChooser(
                        supportRequest, getString(R.string.support_prompt)
                    )
                )
            } catch (e: Exception) {
                // TODO: Добавить какой-нибудь вывод об ошибке
            }
        }

        showUserPolicy.setOnClickListener {
            val userPolicy = Intent(Intent.ACTION_VIEW).apply {
                setData(Uri.parse(getString(R.string.yandex_offer)))
            }
            try {
                startActivity(Intent.createChooser(userPolicy, getString(R.string.show_web_page)))
            } catch (e: Exception) {
                // TODO: Добавить какой-нибудь вывод об ошибке
            }
        }

    }
}