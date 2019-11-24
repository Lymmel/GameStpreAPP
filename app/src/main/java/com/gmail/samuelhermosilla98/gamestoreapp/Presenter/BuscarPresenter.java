package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.BuscarInterface;

public class BuscarPresenter implements BuscarInterface.Presenter{
    private BuscarInterface.View view;

    public BuscarPresenter (BuscarInterface.View view){
        this.view = view;
    }

    public void onClickAdd(){
        view.lanzarFormulario();
    }
}
