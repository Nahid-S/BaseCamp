package com.example.pikachu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class voice12 extends AppCompatActivity {

    private TextView questionTextView;
    private Button nextButton,previousButton;

     // New button for previous question
    private LottieAnimationView btnSpeak;
    private TextView tvText;

    protected static final int RESULT_SPEECH = 1;

    private String[] questions12;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice12);
        // Question cycling
        questionTextView = findViewById(R.id.questionTextView);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);  // Initialize the previous button

        questions12 = getResources().getStringArray(R.array.questions12);
        currentQuestionIndex = 0;

        // Voice recognition
        tvText = findViewById(R.id.tvText);
        btnSpeak = findViewById(R.id.btnSpeak);

        // Display the first question
        displayCurrentQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestionIndex < questions12.length - 1) {
                    currentQuestionIndex++;
                    displayCurrentQuestion();
                } else {
                    Toast.makeText(getApplicationContext(), "You reached the end of the questions", Toast.LENGTH_SHORT).show();
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    displayCurrentQuestion();
                } else {
                    Toast.makeText(getApplicationContext(), "You are at the first question", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    tvText.setText("");
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Your device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Voice recognition result
        if (requestCode == RESULT_SPEECH) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                tvText.setText(text.get(0));
            }
        }
    }

    private void displayCurrentQuestion() {
        questionTextView.setText(questions12[currentQuestionIndex]);
    }
}