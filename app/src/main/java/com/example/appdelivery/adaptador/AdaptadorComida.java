package com.example.appdelivery.adaptador;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appdelivery.R;
import com.example.appdelivery.modelos.Comida;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorComida extends RecyclerView.Adapter<AdaptadorComida.ViewHolder> {

    private int resource;
    private List<Comida> comidaList;

    public AdaptadorComida(List<Comida> comidaList, int resource){
        this.comidaList = comidaList;
        this.resource =  resource;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull AdaptadorComida.ViewHolder viewHolder, int index) {

        Comida comida =comidaList.get(index);
        viewHolder.bind(comida);

        // viewHolder.textViewBebida.setText(bebidas.getNombre());
        //viewHolder.textViewBebida.setText(bebidas.getDescripcion());
        //viewHolder.textViewBebida.setText(bebidas.getPrecio());
        //viewHolder.textViewBebida.setText(bebidas.getImagen());
    }

    @Override
    public int getItemCount() {
        return comidaList.size();
    }


    public class ViewHolder  extends RecyclerView.ViewHolder {

        private TextView textViewComidas;
        private TextView textViewDescripcionComida;
        private TextView textViewPrecioComidas;
        public View view;

        public ViewHolder(View view){
            super(view);

            this.view = view;
            textViewComidas =(TextView) view.findViewById(R.id.textViewComidas);
            textViewDescripcionComida =(TextView) view.findViewById(R.id.textViewComidas);
            textViewPrecioComidas =(TextView) view.findViewById(R.id.textViewComidas);


        }

        public void bind(Comida comida) {
            Log.i("comida" , comida.getNombrecomida());
            textViewComidas.setText(comida.getNombrecomida());
            textViewDescripcionComida.setText(comida.getDescripcioncomida());
            textViewPrecioComidas.setText(comida.getPreciocomida());
        }
    }


}
