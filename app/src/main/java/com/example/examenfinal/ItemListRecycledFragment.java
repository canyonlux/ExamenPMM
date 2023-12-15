package com.example.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenfinal.databinding.FragmentItemListRecyclerBinding;
import com.example.examenfinal.databinding.ViewholderItemListBinding;
import com.example.examenfinal.models.ItemListDetail;

import java.util.List;


public class ItemListRecycledFragment extends Fragment { // Fragmento para la lista de items
    private FragmentItemListRecyclerBinding binding;
    private ItemsViewModel itemsViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { // Metodo para crear la vista del fragmento
        return (binding = FragmentItemListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // Metodo para crear el fragmento
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
        navController = Navigation.findNavController(view);
        ItemAdapter itemAdapter = new ItemAdapter();
        binding.itemRecyclerView.setAdapter(itemAdapter);


        itemsViewModel.getAll().observe(getViewLifecycleOwner(), itemAdapter::setList);
    }


    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> { // Adaptador para la lista de items
        List<ItemListDetail> itemsList;


        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(ViewholderItemListBinding.inflate(getLayoutInflater(), parent, false));
        }


        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) { // Metodo para enlazar los items
            ItemListDetail element = itemsList.get(position);
            holder.binding.setItem(element);
            holder.itemView.setOnClickListener(v -> {
                itemsViewModel.select(element);
                navController.navigate(R.id.action_itemListRecyclerFragment_to_itemsDetailsFragment);
            });
        }


        @Override
        public int getItemCount() {
            return itemsList != null ? itemsList.size() : 0;
        }


        public void setList(List<ItemListDetail> itemList){ // Metodo para establecer la lista de items
            this.itemsList = itemList;
            notifyDataSetChanged();
        }
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder { // Clase para los items
        private final ViewholderItemListBinding binding;


        public ItemViewHolder(ViewholderItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}