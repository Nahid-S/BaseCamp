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

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private List<String> questions;
    private Context context;

    public QuestionAdapter(List<String> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.questionText.setText(questions.get(position));
        holder.questionImage.setImageResource(R.drawable.queslog); // You can set the appropriate drawable here.
    }

    @Override
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
