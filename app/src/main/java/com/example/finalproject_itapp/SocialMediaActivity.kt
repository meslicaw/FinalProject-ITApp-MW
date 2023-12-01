package com.example.finalproject_itapp

import android.os.Bundle

import android.webkit.WebSettings

import android.webkit.WebView

import androidx.appcompat.app.AppCompatActivity

class SocialMediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_social_media)

        val socialMediaWebView: WebView = findViewById(R.id.socialMediaWebView)

        val webSettings: WebSettings = socialMediaWebView.settings

        webSettings.javaScriptEnabled = true

        socialMediaWebView.loadUrl("https://www.facebook.com/uccjamaica/")

        socialMediaWebView.loadUrl("https://twitter.com/UCCjamaica")

        socialMediaWebView.loadUrl("https://www.instagram.com/uccjamaica/")

    }

}