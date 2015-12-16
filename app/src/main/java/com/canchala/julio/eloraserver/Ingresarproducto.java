package com.canchala.julio.eloraserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Ingresarproducto extends AppCompatActivity {

    private Firebase mRef;
    private Button ingresar;
    private EditText nombre;
    private EditText cantidad;
    private EditText costo;
    private EditText fabricante;
    private String snombre;
    private String scantidad;
    private String scosto;
    private String sfabricante;
    private String tipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresarproducto);

        ingresar=(Button)findViewById(R.id.BIngresar);
        nombre=(EditText)findViewById(R.id.nombrei);
        cantidad=(EditText)findViewById(R.id.cantidadi);
        costo=(EditText)findViewById(R.id.costoi);
        fabricante=(EditText)findViewById(R.id.fabricantei);

        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://eloraserver.firebaseio.com/");


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    snombre = nombre.getText().toString();
                    scantidad = cantidad.getText().toString();
                    scosto = costo.getText().toString();
                    sfabricante = fabricante.getText().toString();

                    Firebase productos = mRef.child("Productos").child(snombre);
                    producto nuevo = new producto(snombre, scantidad, scosto, sfabricante, tipo);
                    productos.setValue(nuevo, new Firebase.CompletionListener() {
                        @Override
                        public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                            if (firebaseError != null) {

                                Toast.makeText(Ingresarproducto.this, "El producto no se pudo ingresar" + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(Ingresarproducto.this, "Producto ingresado correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    //productos.push().setValue(nuevo);
            }
        });
    }

    public void selecfrutas(View view){tipo="Frutas";}
    public void seleccarnes(View view){tipo="Carnes";}
    public void seleclacteos(View view){tipo="Lacteos";}
    public void selecenlatados(View view){tipo="Enlatados";}

}
