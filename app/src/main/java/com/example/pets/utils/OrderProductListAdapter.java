package com.example.pets.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.models.Cart;
import com.example.pets.models.Product;

import java.util.HashMap;
import java.util.List;

public class OrderProductListAdapter extends RecyclerView.Adapter<OrderProductListAdapter.ViewHolder> {
    private List<Product> products;
    public HashMap<Integer, Integer> cart = Cart.getInstance();

    public OrderProductListAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderProductListAdapter.ViewHolder holder, int position) {
        holder.textName.setText(products.get(position).getName());
        holder.textPrice.setText(products.get(position).toCurrency(products.get(position).getPrice()));
        holder.productID = products.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int productID;
        private TextView textName;
        private TextView textPrice;
        private TextView textCounter;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textCounter = itemView.findViewById(R.id.textCounter);
            textPrice = itemView.findViewById(R.id.textPrice);

            ImageButton buttonAdd = itemView.findViewById(R.id.buttonAdd);
            ImageButton buttonRemove = itemView.findViewById(R.id.buttonRemove);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    cart.compute(productID, (key, value) -> (value == null) ? 1 : value + 1);
                    textCounter.setText(String.valueOf(cart.get(productID)));
                }
            });

            buttonRemove.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    cart.compute(productID, (key, value) -> {
                        if (value == null || value == 0) {
                            cart.remove(key);
                            textCounter.setText(String.valueOf(0));

                        } else {
                            value -= 1;
                            textCounter.setText(String.valueOf(cart.get(productID)));
                        }
                        return value;
                    });
                }
            });
        }
    }
}
