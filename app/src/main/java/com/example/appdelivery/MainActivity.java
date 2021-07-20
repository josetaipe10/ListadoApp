package com.example.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdelivery.PerfilActivity;
import com.example.appdelivery.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button btn_login,btn_registrar;
    EditText edtUsuario,edtClave;



    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("Usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario =  findViewById(R.id.edt_Usuario);
        edtClave =  findViewById(R.id.edt_Clave);

        btn_login =  findViewById(R.id.login_btnRegistrar);
        btn_registrar =  findViewById(R.id.login_btnEntrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot data :dataSnapshot.getChildren()){
                            String nombre = data.child( "Correo" ).getValue( String.class );
                            String clave = data.child( "Contraseña" ).getValue( String.class );
                            //System.out.println(nombre);

                            if(nombre.equals(edtUsuario.getText().toString())

                                    && clave.equals(edtClave.getText().toString())){
                                startActivity(new Intent(MainActivity.this, PerfilActivity.class));
                                return;
                            }else{
                                Toast.makeText(getApplicationContext(), "datos incorrectos", Toast.LENGTH_SHORT).show();
                            }
                            System.out.println(data.getValue());
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objI = new  Intent(MainActivity.this,RegistrarCliente.class);
                startActivity(objI);
            }
        });
    }

}