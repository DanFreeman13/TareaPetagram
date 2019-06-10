package com.danielfreeman.tareapetagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1, "Puchi", 0));
        mascotas.add(new Mascota(R.drawable.perro2, "SitSit", 0));
        mascotas.add(new Mascota(R.drawable.perro3, "Huihui", 0));
        mascotas.add(new Mascota(R.drawable.perro4, "Doggy", 0));
        mascotas.add(new Mascota(R.drawable.perro5, "Jojo", 0));
        mascotas.add(new Mascota(R.drawable.perro6, "Tiqui", 0));
        mascotas.add(new Mascota(R.drawable.perro7, "Corky", 0));
        mascotas.add(new Mascota(R.drawable.perro8, "Al", 0));
        mascotas.add(new Mascota(R.drawable.perro9, "Ronron", 0));
        mascotas.add(new Mascota(R.drawable.perro10, "Toto", 0));


    }

    public void irAFavoritas(View v){
        Intent intent = new Intent(this, Favoritas.class);
        startActivity(intent);
    }
}
