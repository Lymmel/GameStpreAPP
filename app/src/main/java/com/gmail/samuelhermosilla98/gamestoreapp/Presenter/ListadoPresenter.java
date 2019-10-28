package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.ListadoInterface;

public class ListadoPresenter implements ListadoInterface.Presenter {
    private ListadoInterface.View view;

    public ListadoPresenter (ListadoInterface.View view){
        this.view = view;
    }

    public void onClickAdd(){
        view.lanzarFormulario();
    }
}
