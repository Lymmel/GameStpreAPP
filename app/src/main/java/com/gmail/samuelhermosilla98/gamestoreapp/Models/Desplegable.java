package com.gmail.samuelhermosilla98.gamestoreapp.Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Desplegable {
    private Integer id;
    private String texto;

    public Desplegable(Integer id, String texto) {
        setId(id);

        setTexto(texto);
    }

    public Desplegable(){

    }

    public Integer getId() {
        return id;
    }

    public boolean setId(Integer id) {
        if(id!=null){
            this.id = id;
            return true;
        }else{
            return false;
        }
    }

    public String getTexto() {
        return texto;
    }

    public boolean setTexto(String texto) {
        String stringPattern= "^[a-zA-Z ]*$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(texto);
        if (matcher.matches()) {
            this.texto = texto;
            return true;
        } else {
            return false;
        }
    }
}
