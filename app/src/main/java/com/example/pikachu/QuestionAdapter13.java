package com.example.pikachu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuestionAdapter13 {
    private List<String> questions;
    private Context context;

    public QuestionAdapter13(List<String> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @NonNull

    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionAdapter.ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {
        holder.questionText.setText(questions.get(position));
        holder.questionImage.setImageResource(R.drawable.queslog); // You can set the appropriate drawable here.
    }


    public int getItemCount() {
        return questions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView questionImage;
        TextView questionText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionImage = itemView.findViewById(R.id.questionImage);
            questionText = itemView.findViewById(R.id.questionText);
        }
    }
}
