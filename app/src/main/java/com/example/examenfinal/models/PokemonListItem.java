package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

public class PokemonListItem {
    @SerializedName("name")
    private String name;

    // Opcional: URL del detalle del Pokémon, si decides implementarlo
    @SerializedName("url")
    private String url;

    // Constructor, getters y setters

    public PokemonListItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
