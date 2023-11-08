package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bookrl1 extends AppCompatActivity {

    private WebView webView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookrl1);


    }


    public void booktotest(View view) {
        Intent intent = new Intent(bookrl1.this, codetest.class);
        startActivity(intent);
    }
}