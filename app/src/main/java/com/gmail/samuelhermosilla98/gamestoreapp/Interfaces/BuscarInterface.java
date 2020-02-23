package com.gmail.samuelhermosilla98.gamestoreapp.Interfaces;

import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;

import java.util.ArrayList;

public interface BuscarInterface {
    interface View {
        void lanzarFormulario();
    }

    interface Presenter{
        void onClickAdd();
        ArrayList<Juego> searchByDate(String n);
        ArrayList<Juego> searchByName(String n);
    }

}
