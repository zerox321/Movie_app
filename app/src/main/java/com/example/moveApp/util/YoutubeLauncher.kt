package com.example.moveApp.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri


object YoutubeLauncher {
    fun Context.watchYoutubeVideo(id: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$id")
        )
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }

    }
}