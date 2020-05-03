package com.example.pets.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.enums.Roles;
import com.example.pets.models.User;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<User> users;

    public RecyclerViewAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textName.setText(users.get(position).getFullName());
        holder.textRole.setText(Roles.stringfy(users.get(position).getRole()));
        holder.textPhone.setText(String.valueOf(users.get(position).getPhone()));
        holder.userID = users.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int userID;
        private ConstraintLayout itemsLayout;
        private TextView textName, textRole, textPhone, buttonEdit, buttonDetails, buttonRemove;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemsLayout = itemView.findViewById(R.id.itemsLayout);
            textName = itemView.findViewById(R.id.textName);
            textRole = itemView.findViewById(R.id.textRole);
            textPhone = itemView.findViewById(R.id.textPhone);
            buttonDetails = itemView.findViewById(R.id.textDetails);
            buttonEdit = itemView.findViewById(R.id.textEdit);
            buttonRemove = itemView.findViewById(R.id.textRemove);

            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

            buttonDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

            buttonRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
