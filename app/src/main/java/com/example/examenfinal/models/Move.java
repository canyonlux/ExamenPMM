package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Move {

    @SerializedName("accuracy")
    private Integer accuracy; // Cambiado de String a Integer, ya que la precisión suele ser un valor numérico

    @SerializedName("name")
    private String name;

    // La lista de Pokémon ya está correctamente serializada con la anotación @SerializedName
    @SerializedName("learned_by_pokemon")
    private List<PokemonListItem> pokemons;

    // Los getters y setters se mantienen iguales

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonListItem> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonListItem> pokemons) {
        this.pokemons = pokemons;
    }

    public String getPokemonsString() {
        StringBuilder s = new StringBuilder();
        for (PokemonListItem pokemon : pokemons) {
            if (s.length() > 0) {
                s.append(", "); // Añadido para separar los nombres de los Pokémon
            }
            s.append(pokemon.getName());
        }
        return s.toString();
    }
}
