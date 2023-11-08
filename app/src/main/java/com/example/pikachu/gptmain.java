package com.example.pikachu;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class gptmain extends AppCompatActivity {

    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gptmain);

        webView1 = findViewById(R.id.webView);

        // Enable JavaScript (optional)
        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a custom WebViewClient to handle URL loading within the WebView
        webView1.setWebViewClient(new MyWebViewClient());

        // Load your initial URL
        webView1.loadUrl("https://alcohol.b4sync.com");
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