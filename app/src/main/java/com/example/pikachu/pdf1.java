package com.example.pikachu;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class pdf1 extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1);

        webView = findViewById(R.id.webView2);

        // Enable JavaScript (optional)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a custom WebViewClient to handle URL loading within the WebView
        webView.setWebViewClient(new MyWebViewClient());

        // Load your initial URL
        webView.loadUrl("https://ielts.aspen-bd.com");
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
}