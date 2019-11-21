package com.gmail.samuelhermosilla98.gamestoreapp.Models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gmail.samuelhermosilla98.gamestoreapp.R;


public class AdaptadorDatosDeLaLista extends RecyclerView.Adapter<AdaptadorDatosDeLaLista.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        //campos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;

        public ViewHolder(View v){
            super(v);

            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombreid);
            precio = (TextView) v.findViewById(R.id.precio);
        }
    }

    @Override
    public int getItemCount(){
        return DatosDeLaLista.DATOS.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_game_store, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        DatosDeLaLista itemActual = DatosDeLaLista.DATOS.get(i);

        Glide.with(viewHolder.imagen.getContext())
                .load(itemActual.getImagen())
                .into(viewHolder.imagen);

        viewHolder.nombre.setText(itemActual.getNombre());

        viewHolder.precio.setText(itemActual.getPrecio()+"");

    }
}
