package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wpGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wp_game);
    }

    public void wpCrossWord(View view) {
        Intent intent = new Intent(wpGame.this, wpCrossword.class);
        startActivity(intent);
    }

    public void wpFlash(View view) {
        Intent intent = new Intent(wpGame.this, wpFlashcard.class);
        startActivity(intent);
    }

    public void wpMatch(View view) {
        Intent intent = new Intent(wpGame.this, wpMatchgame.class);
        startActivity(intent);
    }

    public void wpQuizs(View view) {
        Intent intent = new Intent(wpGame.this, wpQuiz.class);
        startActivity(intent);
    }

    public void goTestGame(View view) {
        Intent intent = new Intent(wpGame.this, wpCrossword.class);
        startActivity(intent);
    }
}