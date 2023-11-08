package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class chatGuru extends AppCompatActivity {

    private WebView webView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_guru);

        webView3 = findViewById(R.id.webviewguru);

        // Enable JavaScript (optional)
        WebSettings webSettings = webView3.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a custom WebViewClient to handle URL loading within the WebView
        webView3.setWebViewClient(new chatGuru.MyWebViewClient());

        // Load your initial URL
        webView3.loadUrl("https://basecampstudy.co.uk/new_b/");
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

//    @Override
//    public void onBackPressed() {
//        if (webView3.canGoBack()) {
//            webView3.goBack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}