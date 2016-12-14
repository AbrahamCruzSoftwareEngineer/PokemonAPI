package com.evolutiondso.www.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.evolutiondso.www.pokedex.model.Pokemon;
import com.evolutiondso.www.pokedex.model.PokemonRespuesta;
import com.evolutiondso.www.pokedex.pokeapi.PokeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PokeapiTAG_" ;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtaidPokeData();

    }

    private void obtaidPokeData(){
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemones();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if(response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();

                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                    for (int i=0; i<listaPokemon.size(); i++){
                        Pokemon p = listaPokemon.get(i);
                        Log.d(TAG, "Pokemon: " + p.getName());
                    }

                }else{
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {

            }
        });
    }

}
