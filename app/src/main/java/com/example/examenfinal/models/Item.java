package com.example.examenfinal.models;

import com.example.examenfinal.Deserializacion.Cat;
import com.example.examenfinal.Deserializacion.Efectos;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
public class Item { // Clase para guardar los datos de los items
    private String name;
    @SerializedName("category")
    @JsonAdapter(Cat.class)
    private String category;
    private String cost;
    @SerializedName("effect_entries")
    @JsonAdapter(Efectos.class)
    private String effect;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCost() {
        return cost;
    }

    public String getEffect() {
        return effect;
    }

    public String getUrl() {
        String index = this.name;
        return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/%s.png", index);
    }
}
