package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    }


    public void lib1(View view) {
        Intent intent = new Intent(menu2.this, bookrl1.class);
        startActivity(intent);
    }

    public void gosplash(View view) {
        Intent intent = new Intent(menu2.this, splash.class);
        startActivity(intent);
    }

    public void readmock1(View view) {
        Intent intent = new Intent(menu2.this, readMock.class);
        startActivity(intent);
    }

    public void booka1(View view) {
        Intent intent = new Intent(menu2.this, bookA1.class);
        startActivity(intent);
    }
}