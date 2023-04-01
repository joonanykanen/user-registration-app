package com.example.userregistrationapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CompletedDegreesAdapter extends RecyclerView.Adapter<CompletedDegreesAdapter.CompletedDegreeViewHolder> {

    private final List<String> completedDegrees;

    public CompletedDegreesAdapter(List<String> completedDegrees) {
        this.completedDegrees = completedDegrees != null ? completedDegrees : new ArrayList<>();
    }

    @NonNull
    @Override
    public CompletedDegreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.completed_degree_item, parent, false);
        return new CompletedDegreeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedDegreeViewHolder holder, int position) {
        String degree = completedDegrees.get(position);
        holder.completedDegreeTextView.setText(String.format("• %s", degree));
    }

    @Override
    public int getItemCount() {
        return completedDegrees.size();
    }

    public static class CompletedDegreeViewHolder extends RecyclerView.ViewHolder {
        TextView completedDegreeTextView;

        public CompletedDegreeViewHolder(@NonNull View itemView) {
            super(itemView);
            completedDegreeTextView = itemView.findViewById(R.id.completedDegreeTextView);
        }
    }
}
