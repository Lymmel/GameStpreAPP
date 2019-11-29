package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.ListadoInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.JuegoModel;

import java.util.ArrayList;

public class ListadoPresenter implements ListadoInterface.Presenter {
    private ListadoInterface.View view;
    private JuegoModel juego;

    public ListadoPresenter (ListadoInterface.View view){
        this.view = view;
        juego = new JuegoModel();
    }

    public void onClickAdd(){
        view.lanzarFormulario(-1);

    }

    public ArrayList<Juego> getAllPerson(){
        return juego.getAllJuegos();
    }

    @Override
    public void onClickRecyclerView(int id) {
        view.lanzarFormulario(id);
    }
}
