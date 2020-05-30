package com.example.pets.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.activities.products.ProductsActivity;
import com.example.pets.enums.Roles;
import com.example.pets.models.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private Context context;
    private List<Product> products;

    public ProductListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        holder.textName.setText(products.get(position).getName());
        holder.textCategory.setText(Roles.stringfy(products.get(position).getCategory()));
        holder.textPrice.setText(String.valueOf(products.get(position).getPrice()));
        holder.productID = products.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int productID;
        private TextView textName;
        private TextView textCategory;
        private TextView textPrice;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textCategory = itemView.findViewById(R.id.textCategory);
            textPrice = itemView.findViewById(R.id.textPrice);

            TextView textDetails = itemView.findViewById(R.id.textDetails);
            TextView textEdit = itemView.findViewById(R.id.textEdit);
            TextView textRemove = itemView.findViewById(R.id.textRemove);

            textDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ProductsActivity) context).show(view, productID);
                }
            });

            textEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ProductsActivity) context).edit(view, productID);
                }
            });

            textRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ProductsActivity) context).remove(view, productID);
                }
            });
        }
    }
}
