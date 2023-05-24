package com.example.e_chalan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var webView:WebView? = null
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the WebView by its unique ID
        webView = findViewById<WebView>(R.id.web)

        // loading http://www.google.com url in the WebView.
        webView!!.loadUrl("https://echallan.mponline.gov.in/")

        // this will enable the javascript.
        webView!!.settings.javaScriptEnabled = true
        webView!!.setDownloadListener(DownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })
        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView!!.webViewClient = WebViewClient()

    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
