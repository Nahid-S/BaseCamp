package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wpListenMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wp_listen_menu);
    }

    public void goWpListening(View view) {
        Intent intent = new Intent(wpListenMenu.this, wpListeningTest.class);
        startActivity(intent);
    }

    public void goWpOld(View view) {
        Intent intent = new Intent(wpListenMenu.this, audiobook.class);
        startActivity(intent);
    }
}