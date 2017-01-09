package com.evolutiondso.www.pokedex.pokeapi;

import com.evolutiondso.www.pokedex.model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Albrtx on 14/12/2016.
 */

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
}
