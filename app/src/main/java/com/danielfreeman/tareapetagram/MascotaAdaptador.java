package com.danielfreeman.tareapetagram;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    ArrayList<Mascota> mascotas;
    Activity activity;

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setLikes(1 + Integer.valueOf((String) mascotaViewHolder.tvLikesCV.getText()));
                mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));

                Toast.makeText(activity, mascota.getNombre() + " tiene un nuevo Like!", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton imgHuesoBlanco;

        public MascotaViewHolder(@NonNull View itemView){
            super(itemView);

            imgFoto        = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV     = (TextView) itemView.findViewById(R.id.tvMascotaCV);
            tvLikesCV      = (TextView) itemView.findViewById(R.id.tvLikesCV);
            imgHuesoBlanco = (ImageButton) itemView.findViewById(R.id.imgHuesoBlanco);
        }
    }
}
