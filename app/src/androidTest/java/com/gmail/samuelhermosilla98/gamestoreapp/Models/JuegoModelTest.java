package com.gmail.samuelhermosilla98.gamestoreapp.Models;

import androidx.test.platform.app.InstrumentationRegistry;

import com.gmail.samuelhermosilla98.gamestoreapp.Views.MyApplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JuegoModelTest {

    private JuegoModel juegoModel;
    private  Juego juego;


    @Before
    public void setUp(){
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase("DATABASE_NAME");
        MyApplication.setContext(InstrumentationRegistry.getInstrumentation().getTargetContext());
        juegoModel = JuegoModel.getInstance();

        this.juego = new Juego(1, "League", 5, "01/08/2018", null);

        this.juego = new Juego();
        this.juego.setId(1);
        this.juego.setNombre("LeagueOfLegends");
        this.juego.setPrecio(10);
        this.juego.setFecha("15/05/2010");
        this.juego.setImagen("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");
    }


    //Dentro de este método probaremos todos los métodos de una base de datos. Create Read Update Delete.
    @Test
    public void JuegoCRUD() {
        //Insertar un nuevo juego
        assertTrue(this.juegoModel.addNewGame(this.juego));


        //Modificar juego
        // el numero de elementos actualizados (modificado en este caso = 1)
        Integer id=1;
        id = (this.juegoModel.updateJuego((this.juego)));
        assertEquals(id,juego.getId());


        //Leer de la base de datos.
        //la base de datos cuenta con 18 elementos + 1 que acabamos de insertar
        assertEquals(19,this.juegoModel.leerDatosDB().size());


        //Eliminar juego.
        Integer idd;
        idd = (this.juegoModel.deleteJuego((this.juego)));
        assertEquals(idd,juego.getId());

    }

}
