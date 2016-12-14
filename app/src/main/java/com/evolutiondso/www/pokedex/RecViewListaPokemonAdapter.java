package com.evolutiondso.www.pokedex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evolutiondso.www.pokedex.model.Pokemon;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Albrtx on 14/12/2016.
 */

public class RecViewListaPokemonAdapter extends RecyclerView.Adapter<RecViewListaPokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> dataset;

    public RecViewListaPokemonAdapter(){
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.nombre.setText(p.getName());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.recyclerView_pok_img)
        private ImageView foto;
        @BindView(R.id.recyclerView_pok_text)
        private TextView nombre;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
