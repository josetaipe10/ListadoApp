package com.example.appdelivery;

import androidx.appcompat.app.AppCompatActivity;

public class Listadodecomidas_Activity extends AppCompatActivity {

   /* RecyclerView recyclerView;
    Button button;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("Comida");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carritocomida);


        recyclerView = findViewById(R.id.lvcomidas);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Attach a listener to read the data at our posts reference
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Carritocomida post = dataSnapshot.getValue(Carritocomida.class);
                        System.out.println(post);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
              //  starActivityList();
            }
        });


        ComidaAdaptador adaptador = new ComidaAdaptador(listadecomidas());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);

    }

    private void starActivityList() {
        Intent intent = new Intent (this, lista.class);
        startActivity(intent);
    }

    private List<Comida>listadecomidas(){
        List <Comida> listadecomida = new ArrayList<>();
        Comida comida1 = new Comida();
        comida1.setNombre("Hamburguesa");
        comida1.setDescripcion("Carne, pan");
        comida1.setImagen(R.drawable.hamburguesa);
        listadecomida.add(comida1);
        Comida comida2 = new Comida();
        comida2.setNombre("Pizza");
        comida2.setDescripcion("pan,queso");
        comida2.setImagen(R.drawable.pizza);
        listadecomida.add(comida2);
        listadecomida.add (comida2);
        Comida comida3 = new Comida();
        comida3.setNombre("Broaster");
        comida3.setDescripcion("Pollo,papas");
        comida3.setImagen(R.drawable.broaster);
        return listadecomida;
    }
*/
}