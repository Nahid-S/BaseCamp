package com.example.pikachu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    //ImageButton logOutButton;
   LottieAnimationView logOutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logOutButton = findViewById(R.id.logmeout);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });
    }

    private void logOut() {
        // Clear the login status
        SharedPreferences sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        // Redirect to the login screen (logintest activity)
        Intent intent = new Intent(this, logintest.class);
        startActivity(intent);

        finish(); // Close the current activity
    }

    public void menu1(View view) {
        Intent intent = new Intent(MainActivity.this, menu1.class);
        startActivity(intent);
    }

    public void readmenu1(View view) {
        Intent intent = new Intent(MainActivity.this, menu2.class);
        startActivity(intent);
    }

    public void gotopdf1(View view) {
        Intent intent = new Intent(MainActivity.this, pdf1.class);
        startActivity(intent);
    }

    public void writingques(View view) {
        Intent intent = new Intent(MainActivity.this, gptv2.class);
        startActivity(intent);
    }

    public void gotest(View view) {
        Intent intent = new Intent(MainActivity.this, ghost.class);
        startActivity(intent);
    }

    public void audiobook(View view) {
        Intent intent = new Intent(MainActivity.this, audiobook.class);
        startActivity(intent);
    }

    public void dovoice(View view) {
        Intent intent = new Intent(MainActivity.this, voice.class);
        startActivity(intent);
    }

    public void gonwwrite(View view) {
        Intent intent = new Intent(MainActivity.this, nwwritingmenu.class);
        startActivity(intent);
    }

    public void nwlisten(View view) {
        Intent intent = new Intent(MainActivity.this, audiobook.class);
        startActivity(intent);
    }

    public void nwspeak(View view) {
        Intent intent = new Intent(MainActivity.this, nwspeakingmenu.class);
        startActivity(intent);
    }

    public void gptgram(View view) {
        Intent intent = new Intent(MainActivity.this, nwgrammar.class);
        startActivity(intent);
    }

    public void chatguru(View view) {
        Intent intent = new Intent(MainActivity.this, chatGuru.class);
        startActivity(intent);
    }

    public void pronounce(View view) {
        Intent intent = new Intent(MainActivity.this, proman.class);
        startActivity(intent);
    }

    public void govoc(View view) {
        Intent intent = new Intent(MainActivity.this, nwvocab.class);
        startActivity(intent);
    }

    public void gotestgame(View view) {
        Intent intent = new Intent(MainActivity.this, testGame.class);
        startActivity(intent);
    }
}
