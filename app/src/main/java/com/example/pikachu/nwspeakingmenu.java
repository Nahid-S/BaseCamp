package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nwspeakingmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nwspeakingmenu);
    }

    public void dovoice2(View view) {
        Intent intent = new Intent(nwspeakingmenu.this, voice.class);
        startActivity(intent);
    }

    public void dovoice12(View view) {
        Intent intent = new Intent(nwspeakingmenu.this, voice12.class);
        startActivity(intent);
    }

    public void dovoice13(View view) {
        Intent intent = new Intent(nwspeakingmenu.this, voice13.class);
        startActivity(intent);
    }
}