package com.example.myredirectapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
            if (sharedText != null && sharedText.contains("youtube.com")) {
                val encodedUrl = Uri.encode(sharedText)
                val targetUrl = "https://preservetube.com/save?url=$encodedUrl"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(targetUrl))
                browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(browserIntent)
            }
        }

        finish()
    }
}