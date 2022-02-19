package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlogViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_view);

        String blog_url = getIntent().getStringExtra("blog_url");
        getSupportActionBar().hide();

        WebView webView = findViewById(R.id.blog_content);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(blog_url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}