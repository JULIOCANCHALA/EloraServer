package com.canchala.julio.eloraserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Eliminarproducto extends AppCompatActivity {

    private Firebase mRef;
    private EditText nombre;
    private String snombre;
    private Button Eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminarproducto);

        nombre=(EditText)findViewById(R.id.nombree);
        Eliminar=(Button)findViewById(R.id.Beliminar);

        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://eloraserver.firebaseio.com/");


        Eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snombre = nombre.getText().toString();
                Firebase productos = mRef.child("Productos").child(snombre);
                productos.removeValue(new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        if (firebaseError != null) {

                            Toast.makeText(Eliminarproducto.this, "El producto no se pudo Eliminar" + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(Eliminarproducto.this, "Producto eliminado correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}
