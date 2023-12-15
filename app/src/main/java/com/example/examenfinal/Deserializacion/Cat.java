package com.example.examenfinal.Deserializacion;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Cat implements JsonDeserializer<String> { // Clase para deserializar el JSON


    @Override // Método para deserializar el JSON
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return json.getAsJsonObject().get("name").getAsString();
    }
}
