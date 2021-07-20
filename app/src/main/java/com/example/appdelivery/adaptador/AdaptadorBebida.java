package com.example.appdelivery.adaptador;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appdelivery.R;
import com.example.appdelivery.modelos.Bebida;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorBebida extends RecyclerView.Adapter<AdaptadorBebida.ViewHolder> {

    private int resource;
    private List<Bebida> bebidasList;



    public AdaptadorBebida(List<Bebida> bebidasList, int resource){
        this.bebidasList = bebidasList;
        this.resource =  resource;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull AdaptadorBebida.ViewHolder viewHolder, int index) {

        Bebida bebidas =bebidasList.get(index);
        viewHolder.bind(bebidas);

       // viewHolder.textViewBebida.setText(bebidas.getNombre());
        //viewHolder.textViewBebida.setText(bebidas.getDescripcion());
        //viewHolder.textViewBebida.setText(bebidas.getPrecio());
        //viewHolder.textViewBebida.setText(bebidas.getImagen());
    }

    @Override
    public int getItemCount() {
        return bebidasList.size();
    }


    public class ViewHolder  extends RecyclerView.ViewHolder {

        private TextView textViewBebida;
        private TextView textViewDescripcion;
        private TextView textViewPrecio;
        public View view;

        public ViewHolder(View view){
            super(view);

            this.view = view;
            this.textViewBebida =(TextView) view.findViewById(R.id.textViewBebida);
            this.textViewDescripcion =(TextView) view.findViewById(R.id.textViewBebida);
            this.textViewPrecio =(TextView) view.findViewById(R.id.textViewBebida);

        }

        public void bind(Bebida bebidas) {
            //Log.i("bebidas" , bebidas.getNombre());
            textViewBebida.setText(bebidas.getNombre());
            textViewDescripcion.setText(bebidas.getDescripcion());
            textViewPrecio.setText(bebidas.getPrecio());

        }

    }


}
