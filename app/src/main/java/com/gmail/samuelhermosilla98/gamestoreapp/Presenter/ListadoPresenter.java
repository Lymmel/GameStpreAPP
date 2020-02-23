package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import android.widget.Toast;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.ListadoInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.JuegoModel;
import com.gmail.samuelhermosilla98.gamestoreapp.Views.ListadoActivity;

import java.util.ArrayList;
import java.util.List;

public class ListadoPresenter implements ListadoInterface.Presenter {
    private ListadoInterface.View view;
    private JuegoModel juego;

    public ListadoPresenter (ListadoInterface.View view){
        this.view = view;
        juego = JuegoModel.getInstance();
    }
/*
    public void onClickAdd(){
        view.lanzarFormulario(-1);

    }*/

    //pasamos los elementos de la lista
    public ArrayList<Juego> getAllGames(){
        return juego.getAllJuegos();
    }

    @Override
    public void onClickRecyclerView(Juego jg) {
        view.lanzarFormulario(jg);
    }

    //pasamos los elementos de la lista
    public ArrayList<Juego> getAllGamesDB(){
        return juego.leerDatosDB();
    }

    public int remove(Integer id){
        Juego j = new Juego();
        j.setId(id);

        return juego.deleteJuego(j);

    }

    public int updateGame(Juego jgEdit){
        return juego.updateJuego(jgEdit);
    }

}
