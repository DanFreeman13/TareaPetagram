package com.danielfreeman.tareapetagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> cincoFavoritas;
    private RecyclerView listaMascotas;
    private ImageButton estrella;


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
        estrella = findViewById(R.id.ivEstrella);

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAFavoritas();
            }
        });


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>(10);

        mascotas.add(0, new Mascota(R.drawable.perro1, "Puchi", 0));
        mascotas.add(1, new Mascota(R.drawable.perro2, "SitSit", 0));
        mascotas.add(2, new Mascota(R.drawable.perro3, "Huihui", 0));
        mascotas.add(3, new Mascota(R.drawable.perro4, "Doggy", 0));
        mascotas.add(4, new Mascota(R.drawable.perro5, "Jojo", 0));
        mascotas.add(5, new Mascota(R.drawable.perro6, "Tiqui", 0));
        mascotas.add(6, new Mascota(R.drawable.perro7, "Corky", 0));
        mascotas.add(7, new Mascota(R.drawable.perro8, "Al", 0));
        mascotas.add(8, new Mascota(R.drawable.perro9, "Ronron", 0));
        mascotas.add(9, new Mascota(R.drawable.perro10, "Toto", 0));

    }

    public void irAFavoritas(){

        Mascota aux;
        Mascota aux2;

        int tamanio = mascotas.size();
        cincoFavoritas = new ArrayList<>();


        for (int i=0; i<tamanio; i++) {
            if(mascotas.get(i).getLikes() != 0){
                cincoFavoritas.add(mascotas.get(i));
            }

        }

        if(cincoFavoritas.isEmpty() == true || cincoFavoritas.size() < 5){
            Toast.makeText(this, "No tienes Favoritos, selecciona al menos 5!", Toast.LENGTH_LONG).show();
        }
        else {

            Intent intent = new Intent(this, Favoritas.class);


            intent.putExtra("4",
                    cincoFavoritas.get(cincoFavoritas.size()-1).getFoto() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-1).getNombre() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-1).getLikes());
            intent.putExtra("3",
                    cincoFavoritas.get(cincoFavoritas.size()-2).getFoto() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-2).getNombre() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-2).getLikes());
            intent.putExtra("2",
                    cincoFavoritas.get(cincoFavoritas.size()-3).getFoto() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-3).getNombre() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-3).getLikes());
            intent.putExtra("1",
                    cincoFavoritas.get(cincoFavoritas.size()-4).getFoto() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-4).getNombre() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-4).getLikes());
            intent.putExtra("0",
                    cincoFavoritas.get(cincoFavoritas.size()-5).getFoto() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-5).getNombre() + ";" +
                            cincoFavoritas.get(cincoFavoritas.size()-5).getLikes());

            startActivity(intent);

        }




    }
}
