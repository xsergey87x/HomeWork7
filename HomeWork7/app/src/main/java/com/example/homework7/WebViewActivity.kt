package com.example.homework7

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button


class WebViewActivity : AppCompatActivity() {

    private lateinit var myWView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val buttonBack = findViewById<Button>(R.id.butBack)
        val buttonForward = findViewById<Button>(R.id.butForvard)


        myWView = findViewById<WebView>(R.id.webID).apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            webChromeClient = MyChromeWebViewClient()
            loadUrl("https://olx.ua")
        }

        buttonBack.setOnClickListener()
        {
            if (myWView.canGoBack()) {
                myWView.goBack()
            }

            buttonForward.setOnClickListener()
            {
                if (myWView.canGoForward()) {
                    myWView.goForward()
                }
            }
        }
    }

    override fun onBackPressed() {

        if (myWView.canGoBack()) {
            myWView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}

private class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return false
    }
}

private class MyChromeWebViewClient : WebChromeClient() {
    //  handle data from sites
}