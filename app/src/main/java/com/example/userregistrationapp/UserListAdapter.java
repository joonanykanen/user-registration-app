package com.example.userregistrationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private ArrayList<User> users;
    private Context context;

    public UserListAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameTextView.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        holder.emailTextView.setText(user.getEmail());
        holder.degreeProgramTextView.setText(user.getDegreeProgram());

        int imageId = context.getResources().getIdentifier(user.getImagePath(), "drawable", context.getPackageName());
        holder.userImageView.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView emailTextView;
        TextView degreeProgramTextView;
        ImageView userImageView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            degreeProgramTextView = itemView.findViewById(R.id.degreeProgramTextView);
            userImageView = itemView.findViewById(R.id.userImageView);
        }
    }
}
