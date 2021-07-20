package com.example.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {
    ImageButton btimggaseosa,btimgcomida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    btimggaseosa = findViewById(R.id.imgBg);
    btimgcomida = findViewById(R.id.imgBc);

    btimggaseosa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent objI = new  Intent(PerfilActivity.this,DetalleActivity.class);
            startActivity(objI);
        }
    });

    btimgcomida.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent objI = new  Intent(PerfilActivity.this,Listadodecomidas_Activity.class);
            startActivity(objI);
        }
    });
    }
}