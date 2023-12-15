package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Move { // Clase para guardar los datos de los movimientos
    private String accuracy;
    private String name;


    @SerializedName("learned_by_pokemon")
    private List<PokemonListItem> pokemons;

    public String getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public List<PokemonListItem> getPokemons() {
        return pokemons;
    }


    public String getPokemonsString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; pokemons != null && i<pokemons.size(); i++) {
            s.append(pokemons.get(i).getName()).append(" ");
        }
        return s.toString();
    }

}
