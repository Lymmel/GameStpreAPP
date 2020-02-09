package com.gmail.samuelhermosilla98.gamestoreapp.Interfaces;

import android.content.Context;

import com.gmail.samuelhermosilla98.gamestoreapp.Models.Desplegable;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;

public interface FormularioInterface {

    interface View{
        void clickBackButton();
        void requestPermission();
    }

    interface Presenter{
        void onClickBackButton();
        void onclickImage(Context myContext);
        void resultPermission(int result);
        void onClickSaveButton(Juego newJuego, Desplegable newDesplegable);

    }


}
