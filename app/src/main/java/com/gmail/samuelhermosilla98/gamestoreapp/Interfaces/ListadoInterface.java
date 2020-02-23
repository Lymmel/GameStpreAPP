package com.gmail.samuelhermosilla98.gamestoreapp.Interfaces;


import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;

import java.util.ArrayList;
import java.util.List;

public interface ListadoInterface {
    interface View {
        void lanzarFormulario();
        void lanzarFormulario(Juego jg);
    }

    interface Presenter{
        //void onClickAdd();
        ArrayList<Juego> getAllGames();
        void onClickRecyclerView(Juego jg);
        ArrayList<Juego> getAllGamesDB();
        int remove(Integer id);
        int updateGame(Juego jgEdit);
    }
}

