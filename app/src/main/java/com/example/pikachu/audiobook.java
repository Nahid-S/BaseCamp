package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class audiobook extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiobook);
        webView = findViewById(R.id.webaudio);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // Web settings
        webView.loadUrl("https://ielts.mrperfect.lol/category_li/"); // URL

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            // If the WebView cannot go back, navigate to MainActivity and finish this activity
            Intent intent = new Intent(this, wpListenMenu.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.stopLoading();  // Stop loading any ongoing web page
            webView.onPause();      // Pause JavaScript timers, etc.
            webView.clearCache(true); // Clear the WebView cache
            webView.clearHistory();   // Clear the WebView history
            webView.destroy();        // Destroy the WebView
            webView = null;          // Set the WebView to null to release it
        }

        super.onDestroy();
    }
}
