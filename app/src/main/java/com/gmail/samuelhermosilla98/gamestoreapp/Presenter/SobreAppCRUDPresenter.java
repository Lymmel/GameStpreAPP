package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.SobreAppCRUDInterface;

public class SobreAppCRUDPresenter implements SobreAppCRUDInterface.Presenter {
    private SobreAppCRUDInterface.View view;

    public SobreAppCRUDPresenter (SobreAppCRUDInterface.View view){
        this.view = view;
    }

    public void onClickAdd(){
        view.lanzarFormulario();
    }
}
