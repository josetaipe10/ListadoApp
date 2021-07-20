package com.example.appdelivery;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appdelivery.adaptador.AdaptadorComida;
import com.example.appdelivery.modelos.Comida;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetalleComidaActivity extends AppCompatActivity {

    private EditText mEditTextComida;
    private EditText mEditTextDescripcións;
    private EditText mEditTextPrecios;
    private Button mBtnCrearDatoss;
    private DatabaseReference mDatabases;

    private AdaptadorComida mAdapters;
    private RecyclerView mRecycleView;
    private List<Comida> comidaList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallecomida);

        mEditTextComida = (EditText) findViewById(R.id.txtCOMIDA);
        mEditTextDescripcións = (EditText) findViewById(R.id.txtDESCRIPCIONCOMIDA);
        mEditTextPrecios = (EditText) findViewById(R.id.txtPRECIOCOMIDA);
        mBtnCrearDatoss = (Button) findViewById(R.id.btnregistrar);

        mRecycleView = (RecyclerView) findViewById(R.id.recycleViewComidas);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));


        mDatabases = FirebaseDatabase.getInstance().getReference();

        mBtnCrearDatoss.setOnClickListener(view -> {

            String Nombres = mEditTextComida.getText().toString();
            String Descripcionn = mEditTextDescripcións.getText().toString();
            String Precios = mEditTextPrecios.getText().toString();




            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("Nombre" ,Nombres);
            childUpdates.put("Descripcion" ,Descripcionn);
            childUpdates.put("Precio" ,Precios);
            //childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

            mDatabases.child("Comida").push().setValue(childUpdates);

        });

        getComidasFromFirebase();

    }

    private void getComidasFromFirebase(){
        // mDatabase.child("Bebida");
        mDatabases.child("Comida").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    // mBebidasList.clear();

                    for (DataSnapshot ds : snapshot.getChildren()) {
                        // String Nombre = ds.child("nombre").getValue().toString();
                        String nombres = ds.child( "Nombre" ).getValue( String.class );
                        String descripcionn = ds.child( "Descripcion" ).getValue( String.class );
                        String precios = ds.child( "Precio" ).getValue( String.class );
                        //Log.i("descripcion : ",descripcion);
                        Comida comida = new Comida(nombres,descripcionn,precios);
                        comidaList.add(comida);
                    }

                    mAdapters = new AdaptadorComida(comidaList, R.layout.activitylscomidas);

                    mRecycleView.setAdapter(mAdapters);

                }
            }

            @Override
            public void onCancelled(@NotNull DatabaseError databaseError) {

            }
        });
    }
}