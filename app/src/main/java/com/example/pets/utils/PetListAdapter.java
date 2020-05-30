package com.example.pets.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.models.Pet;

import java.util.List;

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.ViewHolder> {
    private Context context;
    private List<Pet> pets;

    public PetListAdapter(Context context, List<Pet> pets) {
        this.context = context;
        this.pets = pets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pets_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PetListAdapter.ViewHolder holder, int position) {

        holder.textName.setText(pets.get(position).getName());
        holder.textSpecie.setText(pets.get(position).getSpecie().toString());
        holder.textBreed.setText(pets.get(position).getBreed());
        holder.textOwner.setText(pets.get(position).getOwner());
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int petID;
        private TextView textName;
        private TextView textSpecie;
        private TextView textBreed;
        private TextView textOwner;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textSpecie = itemView.findViewById(R.id.textSpecie);
            textBreed = itemView.findViewById(R.id.textBreed);
            textOwner = itemView.findViewById(R.id.textOwner);

            ImageButton imagePets = itemView.findViewById(R.id.imagePets);
            TextView textPets = itemView.findViewById(R.id.textPets);
            ImageButton imageCalendar = itemView.findViewById(R.id.imageCalendar);
            TextView textCalendar = itemView.findViewById(R.id.textCalendar);

            textPets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Pet id:" + petID, Toast.LENGTH_LONG).show();
                }
            });

            textCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Pet id:" + petID, Toast.LENGTH_LONG).show();
                }
            });

            imagePets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Icon for Pet id:" + petID, Toast.LENGTH_LONG).show();
                }
            });

            imageCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Icon for Pet id:" + petID, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
