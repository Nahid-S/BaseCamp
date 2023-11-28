package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class bookrl1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookrl1);


    }


    public void booktotest(View view) {
        Intent intent = new Intent(bookrl1.this, codetest.class);
        startActivity(intent);
    }

    public void goflip(View view) {
        Intent intent = new Intent(bookrl1.this, flipbook1.class);
        startActivity(intent);
    }
}