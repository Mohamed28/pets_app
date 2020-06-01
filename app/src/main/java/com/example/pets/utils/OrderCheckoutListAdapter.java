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
import com.example.pets.models.Cart;
import com.example.pets.models.Product;

import java.util.HashMap;
import java.util.List;

public class OrderCheckoutListAdapter extends RecyclerView.Adapter<OrderCheckoutListAdapter.ViewHolder> {
    private List<Product> products;
    public HashMap<Integer, Integer> cart = Cart.getInstance();

    public OrderCheckoutListAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_checkout_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCheckoutListAdapter.ViewHolder holder, int position) {
        holder.textName.setText(products.get(position).getName());
        holder.textPrice.setText(products.get(position).toCurrency(products.get(position).getPrice()));
        holder.textQuantity.setText((String.valueOf(cart.get(position)) + "x"));
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private TextView textPrice;
        private TextView textQuantity;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textQuantity = itemView.findViewById(R.id.textQuantity);
            textPrice = itemView.findViewById(R.id.textPrice);
        }
    }
}
