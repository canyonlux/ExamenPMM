package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoveList {
    // Utilizamos @SerializedName si la clave en el JSON no coincide exactamente con el nombre de la variable
    @SerializedName("results")
    private ArrayList<MoveListItem> results;

    public ArrayList<MoveListItem> getResults() {
        return results;
    }

    // Método para configurar los resultados, útil si necesitas modificar la lista después de obtenerla de la API
    public void setResults(ArrayList<MoveListItem> results) {
        this.results = results;
    }
}
