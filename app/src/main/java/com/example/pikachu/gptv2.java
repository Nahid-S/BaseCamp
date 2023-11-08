package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class gptv2 extends AppCompatActivity {

    private WebView webView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gptv2);

        webView3 = findViewById(R.id.webv3);

        // Enable JavaScript (optional)
        WebSettings webSettings = webView3.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a custom WebViewClient to handle URL loading within the WebView
        webView3.setWebViewClient(new MyWebViewClient());

        // Load your initial URL
        webView3.loadUrl("https://ielts.aspen-bd.com/");
    }

    // Custom WebViewClient to handle URL loading within the WebView
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Load the URL within the WebView
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView3.canGoBack()) {
            webView3.goBack();
        } else {
            super.onBackPressed();
        }
    }
}