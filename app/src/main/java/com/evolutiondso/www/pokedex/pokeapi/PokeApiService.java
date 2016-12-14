package com.evolutiondso.www.pokedex.pokeapi;

import com.evolutiondso.www.pokedex.model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Albrtx on 14/12/2016.
 */

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemones();
}
