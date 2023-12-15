package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

public class MoveListItem { // Clase para guardar los datos de los movimientos
    @SerializedName("name")
    private String name;


    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
