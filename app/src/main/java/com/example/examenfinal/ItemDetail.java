package com.example.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenfinal.databinding.FragmentItemDetailBinding;


public class ItemDetail extends Fragment { // Fragmento para el detalle de los items

    private FragmentItemDetailBinding binding;
    private ItemsViewModel itemsViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { // Metodo para crear el fragmento
        super.onCreate(savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // Metodo para crear la vista del fragmento
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel.getSelected().observe(getViewLifecycleOwner(), obj -> binding.setItem(obj));
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentItemDetailBinding.inflate(inflater, container, false)).getRoot();
    }
}