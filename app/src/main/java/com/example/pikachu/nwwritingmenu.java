package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nwwritingmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nwwritingmenu);
    }

    public void gptv2main(View view) {
        Intent intent = new Intent(nwwritingmenu.this, gptv2.class);
        startActivity(intent);
    }

    public void ghost(View view) {
        Intent intent = new Intent(nwwritingmenu.this, ghost.class);
        startActivity(intent);
    }

    public void paraf(View view) {
        Intent intent = new Intent(nwwritingmenu.this, parapharase.class);
        startActivity(intent);
    }
}