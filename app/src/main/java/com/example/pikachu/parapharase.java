package com.example.pikachu;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class parapharase extends AppCompatActivity {

    private WebView webPara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parapharase);
        webPara = findViewById(R.id.webpara); // Change the WebView ID in your layout file

        WebSettings webSettings = webPara.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webPara.loadUrl("https://ielts.mrperfect.lol/chat_b/"); // Change the URL here

        webPara.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }
        });

        // Handle onBackPressed using OnBackPressedCallback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webPara.canGoBack()) {
                    webPara.goBack();
                } else {
                    // If the WebView cannot go back, proceed with the normal back button behavior
                    finish();
                }
            }
        };

        // Add the callback to the OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    protected void onDestroy() {
        if (webPara != null) {
            webPara.stopLoading();
            webPara.onPause();
            webPara.clearCache(true);
            webPara.clearHistory();
            webPara.destroy();
            webPara = null;
        }

        super.onDestroy();
    }
}