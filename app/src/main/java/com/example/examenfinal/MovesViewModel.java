package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class MovesViewModel extends AndroidViewModel {
    private final MutableLiveData<Move> selectedMoveMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<MoveListItem>> listElementosMutableLiveData = new MutableLiveData<>();
    private MoveListItem selected;

    public MovesViewModel(@NonNull Application application) {
        super(application);
        PokeAPI.getMoveList(listElementosMutableLiveData);
    }

    MutableLiveData<List<MoveListItem>> getAll(){
        return listElementosMutableLiveData;
    }

    public void select(MoveListItem moveListItem) {
        // Solo realizar la llamada a la API si el elemento seleccionado es diferente
        if (selected == null || !selected.equals(moveListItem)) {
            selected = moveListItem;
            PokeAPI.getMove(selected.getName(), selectedMoveMutableLiveData);
        }
    }

    public MutableLiveData<Move> getSelected() {
        return selectedMoveMutableLiveData;
    }
}

