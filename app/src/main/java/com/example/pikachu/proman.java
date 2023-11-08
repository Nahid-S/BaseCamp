package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class proman extends AppCompatActivity {

    private EditText editTextWord;
    private Button buttonPronounce;
    private Button buttonSlow;
    private Button buttonNormal;
    private Button buttonFast;
    private Button buttonEnglish;
    private Button buttonBritish;
    private Button buttonIndia;
    private TextView textViewPronunciation;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proman);

        editTextWord = findViewById(R.id.editTextWord);
        buttonPronounce = findViewById(R.id.buttonPronounce);
        buttonSlow = findViewById(R.id.buttonSlow);
        buttonNormal = findViewById(R.id.buttonNormal);
        buttonFast = findViewById(R.id.buttonFast);
        buttonEnglish = findViewById(R.id.buttonEnglish);
        buttonBritish = findViewById(R.id.buttonBritish);
        buttonIndia = findViewById(R.id.buttonIndia);
        textViewPronunciation = findViewById(R.id.textViewPronunciation);

        // Initialize TextToSpeech
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.US); // Default language (e.g., US English)

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        // Handle language not available
                        // You can display an error message here
                    }
                }
            }
        });

        buttonPronounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = editTextWord.getText().toString();
                if (!word.isEmpty()) {
                    textToSpeech.speak(word, TextToSpeech.QUEUE_FLUSH, null, null);
                    textViewPronunciation.setText("Pronouncing: " + word);
                }
            }
        });

        buttonSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setSpeechRate(0.5f);
            }
        });

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setSpeechRate(1.0f);
            }
        });

        buttonFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setSpeechRate(1.5f);
            }
        });

        buttonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setLanguage(Locale.US);
            }
        });

        buttonBritish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });

        buttonIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setLanguage(new Locale("hi", "IN")); // For Indian English, you can use the appropriate locale code
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
