package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.BuscarInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.JuegoModel;

import java.util.ArrayList;

public class BuscarPresenter implements BuscarInterface.Presenter{
    private BuscarInterface.View view;
    private JuegoModel juego;

    public BuscarPresenter (BuscarInterface.View view){
        this.view = view;
        juego = JuegoModel.getInstance();
    }

    public void onClickAdd(){
        view.lanzarFormulario();
    }

    public ArrayList<Juego> searchByName(String n){
        return juego.leerDatosDBByName(n);
    }

    public ArrayList<Juego> searchByDate(String n){
        return juego.leerDatosDBByFecha(n);
    }


}
