package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nwlisetenmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nwlisetenmenu);
    }


    public void listennw1(View view) {
        Intent intent = new Intent(nwlisetenmenu.this, audiobook.class);
        startActivity(intent);
    }
}