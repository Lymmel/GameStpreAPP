package com.gmail.samuelhermosilla98.gamestoreapp.Presenter;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.FormularioInterface;

public class FormularioPresenter implements FormularioInterface.Presenter{
    private FormularioInterface.View view;

    public FormularioPresenter (FormularioInterface.View view){
        this.view = view;
    }

    public void onClickBackButton(){
        view.clickBackButton();
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
}
