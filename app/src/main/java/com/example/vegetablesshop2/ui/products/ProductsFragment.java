package com.example.vegetablesshop2.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.vegetablesshop2.MainActivity;
import com.example.vegetablesshop2.R;

public class ProductsFragment extends Fragment {

    private ProductsViewModel productsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productsViewModel =
                ViewModelProviders.of(this).get(ProductsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_products, container, false);


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        ((MainActivity)getActivity()).loadProducts();
                    }
                },
                500);
        return root;
    }
}
