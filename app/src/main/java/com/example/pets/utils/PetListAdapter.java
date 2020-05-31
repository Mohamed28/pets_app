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
        holder.textSpecies.setText(pets.get(position).getSpecie());
        holder.petID = pets.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int petID;
        private TextView textName;
        private TextView textSpecies;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textSpecies = itemView.findViewById(R.id.textSpecies);


            ImageButton imagePets = itemView.findViewById(R.id.imagePets);

            imagePets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Pet id:" + petID, Toast.LENGTH_LONG).show();
                }
            });

            textName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Pet id:" + petID, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
