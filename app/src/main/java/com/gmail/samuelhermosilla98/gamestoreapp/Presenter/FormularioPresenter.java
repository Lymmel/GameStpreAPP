package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.FormularioInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Desplegable;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.JuegoModel;

public class FormularioPresenter implements FormularioInterface.Presenter{
    private FormularioInterface.View view;
    private JuegoModel model;

    public FormularioPresenter (FormularioInterface.View view){
        this.view = view;
        model = JuegoModel.getInstance();
    }

    public void onClickBackButton(){
        view.clickBackButton();
    }

    @Override
    public void onclickImage(Context myContext) {
        int readPermission = ContextCompat.checkSelfPermission(myContext, Manifest.permission.READ_EXTERNAL_STORAGE);
        if(readPermission != PackageManager.PERMISSION_GRANTED){
            this.view.requestPermission();
        }
    }




    public void onFocusChange(FormularioInterface.View view, boolean focus) {}


    //Este metodo nos valdrá para comprobar si el nombre no es un núnero y si el precio si es un número
    public  boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public void resultPermission(int result) {
        if (result == PackageManager.PERMISSION_GRANTED) {
            // Permiso aceptado
            Log.d("AppCRUD","Permiso aceptado");
            //view.launchGallery   =   private void selectPicture()
        } else {
            // Permiso rechazado
            Log.d("AppCRUD","Permiso rechazado");
        }
    }

    @Override
    public void onClickSaveButton(Juego newJuego, Desplegable newDesplegable) {
        if ( model.addNewGame(newJuego)){



            if(model.addNewDesplegable(newDesplegable)){

            }else{

            }
        }else{

        }
    }
}
