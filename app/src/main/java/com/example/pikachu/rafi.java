package com.example.pikachu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;


public class rafi extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rafi);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve the questions from strings.xml
        String[] questionsArray = getResources().getStringArray(R.array.questions);
        List<String> questionsList = Arrays.asList(questionsArray);

        QuestionAdapter adapter = new QuestionAdapter(questionsList, this);
        recyclerView.setAdapter(adapter);
    }


    public void gpt(View view) {
        Intent intent = new Intent(rafi.this, gptmain.class);
        startActivity(intent);
    }
}