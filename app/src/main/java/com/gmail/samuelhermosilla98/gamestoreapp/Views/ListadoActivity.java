package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.gmail.samuelhermosilla98.gamestoreapp.Interfaces.ListadoInterface;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.Juego;
import com.gmail.samuelhermosilla98.gamestoreapp.Models.JuegoModel;
import com.gmail.samuelhermosilla98.gamestoreapp.Presenter.ListadoPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.samuelhermosilla98.gamestoreapp.R;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View {

    public static final String JUEGO_KEY="JUEGO";
    private String TAG = "GameStoreAPP/ListadoActivity";
    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private ListadoPresenter presenters;
    ArrayList<Juego> items;
    JuegoAdapter adaptador;
    ItemTouchHelper.SimpleCallback ithsc = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
            AlertDialog.Builder alert = new AlertDialog.Builder(ListadoActivity.this);
            alert.setMessage("¿Estás seguro de eliminar este item?")
                    .setCancelable(false)
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int position=viewHolder.getAdapterPosition();
                            Integer id = items.get(position).getId();
                            items.remove(position);
                            presenters.remove(id);
                            adaptador.notifyDataSetChanged();

                            displayToast();

                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int position=viewHolder.getAdapterPosition();
                            adaptador.notifyItemChanged(position);
                            dialog.cancel();
                        }
                    });
            AlertDialog title = alert.create();
            title.setTitle("Borrar");
            title.show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenters = new ListadoPresenter(this);

        FloatingActionButton fab = findViewById(R.id.añadir);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Pulsando botón añadir...");
                Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
                intent.putExtra(JUEGO_KEY,new Juego());
                startActivityForResult(intent,1);
                startActivity(intent);
            }
        });



        reciclador = (RecyclerView) findViewById(R.id.reciclador);




        layoutManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(layoutManager);

        items = presenters.getAllGamesDB();
        TextView t = findViewById(R.id.text);
        t.setText(Integer.toString(items.size())+" Elementos");
        adaptador = new JuegoAdapter(items);
        new ItemTouchHelper(ithsc).attachToRecyclerView(reciclador);
        reciclador.setAdapter(adaptador);

        // Asocia el elemento de la lista con una acción al ser pulsado
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al pulsar el elemento
                int position = reciclador.getChildAdapterPosition(v);
                Log.d(TAG, "Click RV: " + items.get(position).getId().toString());
                presenters.onClickRecyclerView(items.get(position));

            }
        });
    }

    @Override
    public void lanzarFormulario() {
        Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);

        startActivity(intent);
    }

    @Override
    public void lanzarFormulario(Juego jg) {
        if(jg == null){
            Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
            intent.putExtra(JUEGO_KEY, jg );
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listado, menu);
        return true;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent2 = new Intent(ListadoActivity.this, BuscarActivity.class);
                startActivityForResult(intent2,2);
                return true;
            case R.id.action_settings222:
                Intent intent3 = new Intent(ListadoActivity.this, SobreAppCRUDActivity.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void displayToast() {
        Toast.makeText(ListadoActivity.this,"Borrado correctamente",Toast.LENGTH_SHORT).show();
    }



    public void addJuegoToAdapter(Juego j){
        if(j!=null){
            items.add(j);
            this.adaptador.notifyDataSetChanged();

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        switch (resultCode){
            case 1:
                Juego jg = data.getParcelableExtra("juego");
                if(jg!=null){
                    addJuegoToAdapter(jg);
                    contadorDB();
                }
            break;

            case 2:
                ArrayList<Juego> jgg = data.getExtras().getParcelableArrayList("juegos");
                adaptador.setItem(jgg);
                break;

        }


    }

    public void contadorDB(){
        TextView t = findViewById(R.id.text);
        try{
            int actualContador = Integer.parseInt(t.getText().toString().trim());
            t.setText(Integer.toString(actualContador ++));

        }catch (Exception e){

        }
    }

}
