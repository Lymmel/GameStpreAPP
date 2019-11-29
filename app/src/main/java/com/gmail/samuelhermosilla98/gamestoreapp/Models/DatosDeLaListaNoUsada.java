package com.gmail.samuelhermosilla98.gamestoreapp.Models;

import com.gmail.samuelhermosilla98.gamestoreapp.R;

import java.util.ArrayList;
import java.util.List;

public class DatosDeLaListaNoUsada {
    String nombre;
    int precio;
    int imagen;

    public DatosDeLaListaNoUsada(String nombre, int precio, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public static final List<DatosDeLaListaNoUsada> DATOS = new ArrayList<>();
    static {
        DATOS.add(new DatosDeLaListaNoUsada("Borderlands3", 60, R.mipmap.borderlands));
        DATOS.add(new DatosDeLaListaNoUsada("Call of Duty", 30, R.mipmap.cod));
        DATOS.add(new DatosDeLaListaNoUsada("Pokemon Espada", 75, R.mipmap.sword));
        DATOS.add(new DatosDeLaListaNoUsada("Counter-Strike", 5, R.mipmap.csgo));
        DATOS.add(new DatosDeLaListaNoUsada("World of Warcraft", 25, R.mipmap.wow));
        DATOS.add(new DatosDeLaListaNoUsada("ImperiumAO", 0, R.mipmap.iao));
        DATOS.add(new DatosDeLaListaNoUsada("Paladins of Champions", 0, R.mipmap.paladins));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
