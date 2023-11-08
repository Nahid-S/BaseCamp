package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testGame extends AppCompatActivity {

    private String[] arrayA1 = {"Apple", "Drink", "Paper"};
    private String[] arrayA2 = {"Tree", "Glass", "Rock"};

    private Button button1s1, buttons2, buttons3, buttons4;
    private Button button1a1, buttonsa2, buttonsa3;
    private TextView scoreText; // TextView for displaying the score

    private List<Integer> s1Indices, a2Indices;
    private Button selectedS1, selectedA2;
    private int score = 0; // Variable to store the score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_game);

        // Initialize buttons
        button1s1 = findViewById(R.id.button1s1);
        buttons2 = findViewById(R.id.buttons2);
        buttons3 = findViewById(R.id.buttons3);
        buttons4 = findViewById(R.id.buttons4);
        button1a1 = findViewById(R.id.button1a1);
        buttonsa2 = findViewById(R.id.buttonsa2);
        buttonsa3 = findViewById(R.id.buttonsa3);
        scoreText = findViewById(R.id.scoreText); // Initialize the score TextView

        // Initialize lists to hold shuffled indices
        s1Indices = new ArrayList<>();
        a2Indices = new ArrayList<>();

        // Populate lists with indices
        for (int i = 0; i < arrayA1.length; i++) {
            s1Indices.add(i);
            a2Indices.add(i);
        }

        // Shuffle the lists to randomize the order
        Collections.shuffle(s1Indices);
        Collections.shuffle(a2Indices);

        // Set text on buttons
        button1s1.setText(arrayA1[s1Indices.get(0)]);
        buttons2.setText(arrayA1[s1Indices.get(1)]);
        buttons3.setText(arrayA1[s1Indices.get(2)]);

        button1a1.setText(arrayA2[a2Indices.get(0)]);
        buttonsa2.setText(arrayA2[a2Indices.get(1)]);
        buttonsa3.setText(arrayA2[a2Indices.get(2)]);

        // Button click listeners
        button1s1.setOnClickListener(buttonClickListener);
        buttons2.setOnClickListener(buttonClickListener);
        buttons3.setOnClickListener(buttonClickListener);
        buttons4.setOnClickListener(buttonClickListener);
        button1a1.setOnClickListener(buttonClickListener);
        buttonsa2.setOnClickListener(buttonClickListener);
        buttonsa3.setOnClickListener(buttonClickListener);

        updateScore(); // Initialize and display the score
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedButton = (Button) v;

            // Check if this button is already selected
            if (clickedButton == selectedS1 || clickedButton == selectedA2) {
                Toast.makeText(testGame.this, "Don't repeat the same button.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedS1 == null) {
                selectedS1 = clickedButton;
            } else if (selectedA2 == null) {
                selectedA2 = clickedButton;
                int indexS1 = s1Indices.get(getButtonIndex(selectedS1));
                int indexA2 = a2Indices.get(getButtonIndex(selectedA2));

                if (indexS1 == indexA2) {
                    Toast.makeText(testGame.this, "Correct Match!", Toast.LENGTH_SHORT).show();
                    score++; // Increment score for a correct match
                    updateScore();
                } else {
                    Toast.makeText(testGame.this, "Not a Match!", Toast.LENGTH_SHORT).show();
                }

                selectedS1 = null;
                selectedA2 = null;
            }
        }
    };

    private int getButtonIndex(Button button) {
        // Determine the index of the clicked button
        if (button == button1s1) return 0;
        if (button == buttons2) return 1;
        if (button == buttons3) return 2;
        if (button == button1a1) return 0;
        if (button == buttonsa2) return 1;
        if (button == buttonsa3) return 2;
        return -1; // Invalid button
    }

    private void updateScore() {
        scoreText.setText("Score: " + score);
    }
}
