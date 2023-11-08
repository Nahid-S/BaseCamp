package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.Uri;
import android.os.Build;

public class codetest extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codetest);



        webView = findViewById(R.id.webtest);
        WebSettings webSettings = webView.getSettings();

        webView.setHorizontalScrollBarEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);

        // Load the PDF using Google Docs' PDF viewer
        String pdfUrl = "https://docs.google.com/gview?embedded=true&url=" +
                "https://ielts.aspen-bd.com/media/book/Cambridge_Practice_Tests_for_IELTS_1_KCp69Ed.pdf";
        webView.loadUrl(pdfUrl);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Uri.parse(url).getHost().equals("https://ielts.aspen-bd.com")) {
                    // Load URLs from your domain
                    return false;
                }
                // Allow external links to be loaded in the WebView
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
