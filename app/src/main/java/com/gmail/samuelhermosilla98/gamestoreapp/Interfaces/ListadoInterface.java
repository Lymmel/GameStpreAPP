package com.gmail.samuelhermosilla98.gamestoreapp.Interfaces;


import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;

import java.util.ArrayList;
import java.util.List;

public interface ListadoInterface {
    interface View {
        void lanzarFormulario();
        void lanzarFormulario(int id);
    }

    interface Presenter{
        void onClickAdd();
        ArrayList<Juego> getAllGames();
        void onClickRecyclerView(int id);
        ArrayList<Juego> getAllGamesDB();
        int remove(Integer id);

    }
}

