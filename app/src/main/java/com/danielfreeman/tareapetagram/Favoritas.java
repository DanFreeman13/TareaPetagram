package com.danielfreeman.tareapetagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    private RecyclerView listaMascotasFav;
    ArrayList<Mascota> misFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBarNoStar = (Toolbar) findViewById(R.id.miActionBar_noStar);
        setSupportActionBar(miActionBarNoStar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        misFavoritas = new ArrayList<Mascota>();

        Bundle parametros = getIntent().getExtras();

        String mascota;
        String[] values;

        for (int i = 0; i < 5; i++){
            mascota = parametros.getString(String.valueOf(i));
            values = mascota.split(";");
            misFavoritas.add(new Mascota(Integer.valueOf(values[0]), values[1], Integer.valueOf(values[2])));
        }


        listaMascotasFav = findViewById(R.id.rvMascotasFav);

        LinearLayoutManager llmFav = new LinearLayoutManager(this);
        llmFav.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llmFav);
        inicilizarAdapterFav();

    }

    public void inicilizarAdapterFav() {
        MascotaAdaptador adapter = new MascotaAdaptador(misFavoritas, this);
        listaMascotasFav.setAdapter(adapter);
    }
}
