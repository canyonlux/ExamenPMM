package com.example.examenfinal.pokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.example.examenfinal.models.*;

public interface PokeAPIService { // Interfaz que contiene los métodos que se encargan de hacer las peticiones a la API
    String BASE_URL = "https://pokeapi.co/api/v2/"; // URL base de la API

    @GET("move/{name}")
    Call<Move> getMoveById(@Path("name") String id);

    @GET("move")
    Call<MoveList> getMoveList(@Query("limit") int limit, @Query("offset") int offset);




    @GET("item")
    Call<ItemList> getItemList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("item/{name}")
    Call<Item> getItemByName(@Path("name") String name);
}
