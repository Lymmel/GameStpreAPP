package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gmail.samuelhermosilla98.gamestoreapp.R;

public class FormularioActivity extends AppCompatActivity {

    String TAG = "GameStoreAPP/FormularioActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.añadir);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Pulsando botón guardar...");
                Intent intent = new Intent(FormularioActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
    }

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
                Intent intent2 = new Intent(FormularioActivity.this, LogoActivity.class);
                startActivity(intent2);
                return true;
            case R.id.action_settings4:
                Intent intent4 = new Intent(FormularioActivity.this, ListadoActivity.class);
                startActivity(intent4);
                return true;
            case R.id.action_settings3:
                Intent intent3 = new Intent(FormularioActivity.this, FormularioActivity.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
