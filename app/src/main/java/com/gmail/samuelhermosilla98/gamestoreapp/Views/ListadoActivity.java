package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.content.Intent;
import android.os.Bundle;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.ListadoInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.AdaptadorDatosDeLaLista;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.DatosDeLaLista;
import com.gmail.samuelhermosilla98.gamestoreapp.Presenter.ListadoPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.samuelhermosilla98.gamestoreapp.R;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View {

    String TAG = "GameStoreAPP/LogoActivity";
    RecyclerView reciclador;
    LinearLayoutManager layoutManager;
    private ListadoInterface.Presenter presenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenters = new ListadoPresenter(this);

        FloatingActionButton fab = findViewById(R.id.listadoFButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Pulsando botón flotante...");
                Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });



        reciclador = (RecyclerView) findViewById(R.id.reciclador);

        TextView t = findViewById(R.id.text);
        t.setText(DatosDeLaLista.DATOS.size()+" Elementos encontrados");

        layoutManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(layoutManager);

        AdaptadorDatosDeLaLista adaptador = new AdaptadorDatosDeLaLista();
        reciclador.setAdapter(adaptador);
    }

    @Override
    public void lanzarFormulario() {
        Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings2:
                Intent intent2 = new Intent(ListadoActivity.this, LogoActivity.class);
                startActivity(intent2);
                return true;
            case R.id.action_settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
