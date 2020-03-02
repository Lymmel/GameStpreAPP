package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.FormularioInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Desplegable;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.Presenter.FormularioPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.gmail.samuelhermosilla98.gamestoreapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.View, View.OnClickListener {

    //Spinner
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private Juego jg;
    private Integer idUp;
    String pages="https://lymmel.github.io/GameStpreAPP/";

    String TAG = "GameStoreAPP/FormularioActivity";
    private FormularioPresenter presenter;

    private static final String CERO = "0";
    private static final String BARRA = "/";
    final private int CODE_READ_EXTERNAL_STORAGE_PERMISSION = 123;

    //modelo
    EditText nombreEditText;
    EditText precioEditText;
    EditText fechaEditText;

    //inicio DatePicker variables
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
    ImageView galleryImageView;

    //Alert Dialog button
    private Button mButton;
    private Button delAlertBt;
    final Context ct = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nombreEditText = ((TextInputLayout) findViewById(R.id.nombreInputLayout)).getEditText();
        precioEditText = ((TextInputLayout) findViewById(R.id.precioInputLayout)).getEditText();
        fechaEditText = ((TextInputLayout) findViewById(R.id.fechaInputLayout)).getEditText();


        Bundle bl = getIntent().getExtras();
        if(bl != null){
            this.jg=bl.getParcelable(ListadoActivity.JUEGO_KEY);
            if(jg!=null){

                if(jg.getId()==null){
                    Log.d(TAG,"insertando nuevo");
                }else{
                    Log.d(TAG,"modificando"+jg.toString());
                    this.rellenarForm();
                }
            }


        }

        //DatePicker
        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = (EditText) findViewById(R.id.et_mostrar_fecha_picker);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ibObtenerFecha = (ImageButton) findViewById(R.id.imageButton2);
        //Evento setOnClickListener - clic
        ibObtenerFecha.setOnClickListener(this);

        presenter = new FormularioPresenter(this);

        //Botón añadir opción al desplegable del menú
        Button bnuevo = findViewById(R.id.addtospinner);
        final Context c = this;







        spinner = findViewById(R.id.spinnerrr);
        final FloatingActionButton fab = findViewById(R.id.save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Pulsando botón guardar...");
                //Intent intent = new Intent(FormularioActivity.this, ListadoActivity.class);
                //startActivity(intent);
                if(jg.getId()==null){
                    jg.setNombre(nombreEditText.getText().toString());
                    jg.setPrecio(Integer.parseInt(precioEditText.getText().toString()));
                    jg.setFecha(fechaEditText.getText().toString());

                    Desplegable desple = new Desplegable();
                    desple.setTexto(spinner.getSelectedItem().toString());
                    Log.d(TAG,"botón añadir"+jg.toString());
                    presenter.onClickSaveButton(jg, desple);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("juego",jg);
                    setResult(1,resultIntent);
                    finish();
                }else{
                    jg.setNombre(nombreEditText.getText().toString());
                    jg.setPrecio(Integer.parseInt(precioEditText.getText().toString()));
                    jg.setFecha(fechaEditText.getText().toString());

                    Desplegable desple = new Desplegable();
                    desple.setTexto(spinner.getSelectedItem().toString());
                    Log.d(TAG,"botón actualizar"+jg.toString());
                    presenter.updateGame(jg);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder alert = new AlertDialog.Builder(FormularioActivity.this);
                            alert.setMessage("Actualizado correctamente")
                                    .setCancelable(false)
                                    .setPositiveButton("Volver al listado", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intentUpdate = new Intent(FormularioActivity.this, ListadoActivity.class);
                                            startActivity(intentUpdate);
                                        }
                                    });
                            AlertDialog title = alert.create();
                            title.setTitle("Actualizar");
                            title.show();

                        }
                    });
                }
            }
        });


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

        // Definición de la lista de opciones
        ArrayList<String> items = new ArrayList<String>();
        items.add("Categoría:");
        items.add("Shooter.");
        items.add("RolPlayGame.");
        items.add("Estrategia.");
        items.add("Deportes");

        // Definición del Adaptador que contiene la lista de opciones
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        // Definición del Spinner
        spinner = (Spinner) findViewById(R.id.spinnerrr);
        spinner.setAdapter(adapter);

        //Comprobar Nombre a través del Presenter
        TextInputEditText nombreEditText = (TextInputEditText) findViewById(R.id.nombreEditTextInsert);
        nombreEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            //onFocusChange es un método establecido en FormularioPresenter
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    Log.d("AppCRUD", et.getText().toString());

                    //Validamos si el nombre es un número a través del presentador
                    FormularioPresenter fptmp = (FormularioPresenter) presenter;
                    if (fptmp.isNumeric(et.getText().toString()) == true ) {
                        TextInputLayout nombreInputLayout = (TextInputLayout) findViewById(R.id.nombreInputLayout);
                        nombreInputLayout.setError("Nombre incorrecto. Es un valor numérico");
                    } else {
                        TextInputLayout nombreInputLayout = (TextInputLayout) findViewById(R.id.nombreInputLayout);
                        nombreInputLayout.setError("");
                    }
                }
            }
        });

        //Comprobar Precio a través del Presenter
        TextInputEditText precioEditText = (TextInputEditText) findViewById(R.id.precioEditTextInsert);
        precioEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            //onFocusChange es un método establecido en FormularioPresenter
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    Log.d("AppCRUD", et.getText().toString());

                    //Validamos si el precio es un número a través del presentador
                    FormularioPresenter fptmp = (FormularioPresenter) presenter;
                    if (fptmp.isNumeric(et.getText().toString()) == false ) {
                        TextInputLayout precioInputLayout = (TextInputLayout) findViewById(R.id.precioInputLayout);
                        precioInputLayout.setError("Precio incorrecto. Son letras");
                    } else {
                        TextInputLayout precioInputLayout = (TextInputLayout) findViewById(R.id.precioInputLayout);
                        precioInputLayout.setError("");
                    }
                }
            }
        });





        mButton = findViewById(R.id.addtospinner);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(ct);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(ct);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });


        delAlertBt = findViewById(R.id.delete);
        delAlertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(FormularioActivity.this);
                alert.setMessage("¿Estás seguro de eliminar este item?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog title = alert.create();
                title.setTitle("Borrar");
                title.show();
            }
        });


        galleryImageView = findViewById(R.id.gallery);
        galleryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickImage(v.getContext());
                Log.d(TAG, "Pulsando botón abrir galería...");
            }
        });



    }


    private void rellenarForm() {

        this.nombreEditText.setText(this.jg.getNombre());
        this.precioEditText.setText(String.valueOf(this.jg.getPrecio()));
        this.fechaEditText.setText(this.jg.getFecha());
    }

    //DatePicker methods
    @Override
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings2:

            case R.id.action_settings4:
                Intent intent4 = new Intent(FormularioActivity.this, ListadoActivity.class);
                startActivity(intent4);
                return true;
            case R.id.action_settings3:
                Intent intent3 = new Intent(FormularioActivity.this, SobreAppCRUDActivity.class);
                startActivity(intent3);
                return true;
            case R.id.action_settings222help:
                Intent intent33 = new Intent();
                intent33.putExtra(pages,"https://lymmel.github.io/GameStpreAPP/");
                startActivity(intent33);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void clickBackButton() {

    }



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
    public void requestPermission() {
        ActivityCompat.requestPermissions(FormularioActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, CODE_READ_EXTERNAL_STORAGE_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CODE_READ_EXTERNAL_STORAGE_PERMISSION:
                presenter.resultPermission(grantResults[0]);
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }



    public void addJuegoToAdapter(){

    }




}
