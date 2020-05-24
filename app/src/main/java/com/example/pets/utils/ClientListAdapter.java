package com.example.pets.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.activities.clients.ClientsActivity;
import com.example.pets.models.Client;

import java.util.List;

public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.ViewHolder> {
    private Context context;
    private List<Client> clients;

    public ClientListAdapter(Context context, List<Client> clients) {
        this.context = context;
        this.clients = clients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clients_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientListAdapter.ViewHolder holder, int position) {
        holder.textName.setText(clients.get(position).getFullName());
        holder.textID.setText(clients.get(position).getId());
        holder.textEmail.setText(clients.get(position).getEmail());
        holder.clientID = clients.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int clientID;
        private TextView textName, textID, textEmail, textPets, textCalendar;
        private ImageButton imagePets, imageCalendar;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textID = itemView.findViewById(R.id.textID);
            textEmail = itemView.findViewById(R.id.textEmail);
            textPets = itemView.findViewById(R.id.textPets);
            textCalendar = itemView.findViewById(R.id.textCalendar);

            textPets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ClientsActivity) context).show(view, clientID);
                }
            });

            textCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ClientsActivity) context).edit(view, clientID);
                }
            });

            imagePets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ClientsActivity) context).show(view, clientID);
                }
            });

            imageCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ClientsActivity) context).edit(view, clientID);
                }
            });
        }
    }
}
