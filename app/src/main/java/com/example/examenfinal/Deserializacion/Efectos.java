package com.example.examenfinal.Deserializacion;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class Efectos implements JsonDeserializer<String> {


    @Override // Método para deserializar el JSON
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        StringBuilder str = new StringBuilder();
        JsonArray array = json.getAsJsonArray();

        for (JsonElement element : array) {  // Recorre el JSON y lo guarda en un StringBuilder
            str.append(element.getAsJsonObject().get("short_effect").getAsString());
        }

        return str.toString();
    }
}
