package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.BuscarInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Presenter.BuscarPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.gmail.samuelhermosilla98.gamestoreapp.R;

import java.util.ArrayList;
import java.util.Calendar;

public class BuscarActivity extends AppCompatActivity implements BuscarInterface.View, View.OnClickListener{

    String TAG = "GameStoreAPP/BuscarActivity";

    //Spinner
    private Spinner spinner;
    private ArrayAdapter<String> adapter;

    //presentador
    private BuscarInterface.Presenter presenter;

    //inicio DatePicker variables
    private static final String CERO = "0";
    private static final String BARRA = "/";
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Widgets
    EditText etFecha;
    ImageButton ibObtenerFecha;
    //fin DatePicker variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);


        //DatePicker
        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = (EditText) findViewById(R.id.et_mostrar_fecha_picker);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ibObtenerFecha = (ImageButton) findViewById(R.id.imageButton2);
        //Evento setOnClickListener - clic
        ibObtenerFecha.setOnClickListener(this);


        presenter = new BuscarPresenter(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        // Definición de la lista de opciones
        ArrayList<String> items = new ArrayList<String>();
        items.add("Despliega el Spinner");
        items.add("BuscarActivity por nombre.");
        items.add("BuscarActivity por precio.");
        items.add("BuscarActivity por fecha.");

        // Definición del Adaptador que contiene la lista de opciones
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        // Definición del Spinner
        spinner = (Spinner) findViewById(R.id.spinnerrr);
        spinner.setAdapter(adapter);


        Button BSearch = findViewById(R.id.buttonSearch);
        BSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Pulsando botón buscar...");
                Intent intent = new Intent(BuscarActivity.this, ListadoActivity.class);
                startActivity(intent);
                //volvemos a la actividad listado cerrando la actividad buscar.
                finish();
            }
        });
    }


    //DatePicker methods
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton2:
                obtenerFecha();
                break;
        }

    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();
    }
    //Fin DatePicker methods

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Ejecutando onRestart...");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }

    @Override
    public void lanzarFormulario() {

    }
}
