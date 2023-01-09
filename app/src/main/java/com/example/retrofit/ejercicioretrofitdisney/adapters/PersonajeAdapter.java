package com.example.retrofit.ejercicioretrofitdisney.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.ejercicioretrofitdisney.R;
import com.example.retrofit.ejercicioretrofitdisney.VerPersonajeActivity;
import com.example.retrofit.ejercicioretrofitdisney.modelos.Personaje;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeVH> {

    private List<Personaje> objects;
    private int resources;
    private Context context;

    public PersonajeAdapter(List<Personaje> objects, int resources, Context context) {
        this.objects = objects;
        this.resources = resources;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonajeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonajeVH(LayoutInflater.from(context).inflate(resources, null));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeVH holder, int position) {
        Personaje personaje = objects.get(position);
        holder.lblNombre.setText(personaje.getName());

        Picasso.get()
                .load(personaje.getImageUrl())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imgPersonaje);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("ID", String.valueOf(personaje.getId()));
                Intent intent = new Intent(context, VerPersonajeActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PersonajeVH extends RecyclerView.ViewHolder {

        ImageView imgPersonaje;
        TextView lblNombre;

        public PersonajeVH(@NonNull View itemView) {
            super(itemView);

            imgPersonaje = itemView.findViewById(R.id.imgPersonajeCard);
            lblNombre = itemView.findViewById(R.id.lblNombreCard);
        }
    }
}
