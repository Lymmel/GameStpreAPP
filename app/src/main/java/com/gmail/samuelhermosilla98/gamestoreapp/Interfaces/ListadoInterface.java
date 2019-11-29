package com.gmail.samuelhermosilla98.gamestoreapp.Interfaces;


import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;

import java.util.ArrayList;

public interface ListadoInterface {
    interface View {
        void lanzarFormulario();
        void lanzarFormulario(int id);
    }

    interface Presenter{
        void onClickAdd();
        ArrayList<Juego> getAllPerson();
        void onClickRecyclerView(int id);

    }
}

