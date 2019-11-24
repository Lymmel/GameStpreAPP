package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.os.Bundle;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.SobreAppCRUDInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Presenter.SobreAppCRUDPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import com.gmail.samuelhermosilla98.gamestoreapp.R;

public class SobreAppCRUDActivity extends AppCompatActivity implements SobreAppCRUDInterface.View, View.OnClickListener {

    String TAG = "GameStoreAPP/SobreAppCRUDActivity";
    //presentador
    private SobreAppCRUDInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_app_crud);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new SobreAppCRUDPresenter(this);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


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
    public void onClick(View v) {

    }

    @Override
    public void lanzarFormulario() {

    }
}
