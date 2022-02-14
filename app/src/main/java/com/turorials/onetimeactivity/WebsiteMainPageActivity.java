package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteMainPageActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_main_page);
        webView = findViewById(R.id.website_view);

        getSupportActionBar().hide();

        String websiteLink = getIntent().getStringExtra("web");

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(websiteLink);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}