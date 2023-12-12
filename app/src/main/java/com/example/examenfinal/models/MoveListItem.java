package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

public class MoveListItem {
    @SerializedName("name")
    private String name;

    // Añadimos un campo para la URL del detalle del movimiento, que es común en las APIs REST
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    // Setters si necesitas modificar los valores después
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
