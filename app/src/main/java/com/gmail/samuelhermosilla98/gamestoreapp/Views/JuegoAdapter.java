package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.R;

import java.util.ArrayList;
import java.util.List;

public class JuegoAdapter extends RecyclerView.Adapter<JuegoAdapter.AcontecimientoViewHolder>
        implements View.OnClickListener {

    private List<Juego> items;
    private View.OnClickListener listener;

    // Clase interna:
    // Se implementa el ViewHolder que se encargará
    // de almacenar la vista del elemento y sus datos
    public static class AcontecimientoViewHolder
            extends RecyclerView.ViewHolder {

        private TextView TextView_nombre;
        private TextView TextView_precio;
        private ImageView ImageView_image;

        public AcontecimientoViewHolder(View itemView) {
            super(itemView);
            TextView_nombre = (TextView) itemView.findViewById(R.id.nombreid);
            TextView_precio = (TextView) itemView.findViewById(R.id.precioid);
            ImageView_image = (ImageView) itemView.findViewById(R.id.imagen);
        }

        public void AcontecimientoBind(Juego item) {
            TextView_nombre.setText(item.getNombre());
            TextView_precio.setText(item.getPrecio().toString());
            byte[] decodedString = Base64.decode(item.getImagen(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ImageView_image.setImageBitmap(decodedByte);
        }
    }

    // Contruye el objeto adaptador recibiendo la lista de datos
    public JuegoAdapter(@NonNull List<Juego> items) {
        this.items = items;
    }

    // Se encarga de crear los nuevos objetos ViewHolder necesarios
    // para los elementos de la colección.
    // Infla la vista del layout, crea y devuelve el objeto ViewHolder
    @Override
    public AcontecimientoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_game_store, parent, false);
        row.setOnClickListener(this);

        AcontecimientoViewHolder avh = new AcontecimientoViewHolder(row);
        return avh;
    }

    // Se encarga de actualizar los datos de un ViewHolder ya existente.
    @Override
    public void onBindViewHolder(AcontecimientoViewHolder viewHolder, int position) {
        Juego item = items.get(position);
        viewHolder.AcontecimientoBind(item);
    }

    // Indica el número de elementos de la colección de datos.
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Asigna un listener al elemento
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
