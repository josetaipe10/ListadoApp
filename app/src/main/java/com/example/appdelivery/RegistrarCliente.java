package com.example.appdelivery;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class RegistrarCliente extends AppCompatActivity {
   private EditText TextNombre;
   private EditText TextEmail;
   private EditText TextTelefono;
   private EditText TextContraseña;
   private Button BotonRegistrar;

   // variables de los datos que vamos a registrar
   private  String nombre = "";
   private  String email = "";
   private  String telefono = "";
   private  String clave = "";

   FirebaseAuth mAuth;
   DatabaseReference mDatabase;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_registrar_cliente);

      mAuth = FirebaseAuth.getInstance();
      mDatabase = FirebaseDatabase.getInstance().getReference();

      TextNombre = (EditText) findViewById(R.id.txtNombre);
      TextEmail = (EditText) findViewById(R.id.txtEmail);
      TextTelefono = (EditText) findViewById(R.id.txtTelefono);
      TextContraseña = (EditText) findViewById(R.id.txtClave);
      BotonRegistrar = (Button) findViewById(R.id.bt_Registro);

      BotonRegistrar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            nombre = TextNombre.getText().toString();
            email = TextEmail.getText().toString();
            telefono = TextTelefono.getText().toString();
            clave = TextContraseña.getText().toString();

            if (!nombre.isEmpty() && !email.isEmpty() && !telefono.isEmpty() && !clave.isEmpty()) {

               if (clave.length() >= 6) {
                  registrarUsuario();
               } else {
                  Toast.makeText(RegistrarCliente.this, "La contraseña debe tener al menos 6 caracteristicas", Toast.LENGTH_SHORT).show();
               }
            }
         }
      });

   }
   private void registrarUsuario(){
      mAuth.createUserWithEmailAndPassword(email, clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {

               Map<String, Object> map = new HashMap<>();
               map.put("Nombre", nombre);
               map.put("Correo", email);
               map.put("Telefono", telefono);
               map.put("Contraseña", clave);

               String id = mAuth.getCurrentUser().getUid();

               mDatabase.child("Usuario").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NotNull Task<Void> task2) {
                     if (task2.isSuccessful()) {
                        startActivity(new Intent(RegistrarCliente.this, PerfilActivity.class));
                        finish();
                     }
                     else {
                        Toast.makeText(RegistrarCliente.this, "no se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                     }
                  }
               });
            }
            else {
               Toast.makeText(RegistrarCliente.this,"No se pudo registar este usuario",Toast.LENGTH_SHORT).show();
            }
         }


      });
   }



}