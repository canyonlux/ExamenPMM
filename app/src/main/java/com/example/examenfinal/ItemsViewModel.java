package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemListDetail;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;


public class ItemsViewModel extends AndroidViewModel { // ViewModel para los items
    MutableLiveData<Item> selectedItemMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<ItemListDetail>> listElementosMutableLiveData = new MutableLiveData<>();
    ItemListDetail selected;


    public ItemsViewModel(@NonNull Application application) { // Metodo para crear el ViewModel
        super(application);
        PokeAPI.getItemList(listElementosMutableLiveData);
    }


    MutableLiveData<List<ItemListDetail>> getAll(){
        return listElementosMutableLiveData;
    }


    public void select(ItemListDetail itemListDetails) {
        selected = itemListDetails;
    }


    public MutableLiveData<Item> getSelected() { // Metodo para obtener el item seleccionado
        PokeAPI.getItem(selected.getName(), selectedItemMutableLiveData);
        return selectedItemMutableLiveData;
    }
}