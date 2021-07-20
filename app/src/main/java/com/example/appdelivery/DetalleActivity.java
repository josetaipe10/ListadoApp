package com.example.appdelivery;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdelivery.adaptador.AdaptadorBebida;
import com.example.appdelivery.modelos.Bebida;
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

public class DetalleActivity extends AppCompatActivity {

    private EditText mEditTextBebida;
    private EditText mEditTextDescripción;
    private EditText mEditTextPrecio;
    private Button mBtnCrearDatos;
    private DatabaseReference mDatabase;

    private AdaptadorBebida mAdapter;
    private RecyclerView mRecycleView;
    private List<Bebida> bebidaList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        mEditTextBebida = (EditText) findViewById(R.id.txtBEBIDA);
        mEditTextDescripción = (EditText) findViewById(R.id.txtDESCRIPCION);
        mEditTextPrecio = (EditText) findViewById(R.id.txtPRECIO);
        mBtnCrearDatos = (Button) findViewById(R.id.btnregistrar);

        mRecycleView = (RecyclerView) findViewById(R.id.recycleViewBebidas);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));


        mDatabase = FirebaseDatabase.getInstance().getReference();

        mBtnCrearDatos.setOnClickListener(view -> {
            String Nombre = mEditTextBebida.getText().toString();
            String Descripcion = mEditTextDescripción.getText().toString();
            String Precio = mEditTextPrecio.getText().toString();




            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("Nombre" ,Nombre);
            childUpdates.put("Descripcion" ,Descripcion);
            childUpdates.put("Precio" ,Precio);
            //childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

            mDatabase.child("Bebida").push().setValue(childUpdates);

        });

        getBebidasFromFirebase();

    }

    private void getBebidasFromFirebase(){
       // mDatabase.child("Bebida");
        mDatabase.child("Bebida").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    bebidaList.clear();

                    for (DataSnapshot ds : snapshot.getChildren()) {
                       // String Nombre = ds.child("nombre").getValue().toString();

                        String nombre = ds.child( "Nombre" ).getValue( String.class );
                        String descripcion = ds.child( "Descripcion" ).getValue( String.class );
                        String precio = ds.child( "Precio" ).getValue( String.class );

                        /*Log.i("nombre : ",nombre);
                        Log.i("descripcion : ",descripcion);
                        Log.i("precio : ",precio);*/
                        Bebida bebida = new Bebida(nombre,descripcion,precio);
                        bebidaList.add(bebida);
                        //bebidaList.add(new Bebida(nombre,descripcion,precio));
                    }

                    mAdapter = new AdaptadorBebida(bebidaList, R.layout.activitylsbebidas);

                    mRecycleView.setAdapter(mAdapter);

                }
            }

            @Override
            public void onCancelled(@NotNull DatabaseError databaseError) {

            }
        });
    }
}