package com.canchala.julio.eloraserver;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

public class Listar extends AppCompatActivity {

    private Firebase mRef;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        Firebase.setAndroidContext(this);
        listView = (ListView) findViewById(R.id.list);
        mRef = new Firebase("https://eloraserver.firebaseio.com/");

        Firebase productos = mRef.child("Productos");

        productos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                int contador = (int) snapshot.getChildrenCount();
                int i = 0;
                String[] produc = new String[contador];
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    mercancia merc = postSnapshot.getValue(mercancia.class);
                    produc[i] = merc.getNombre();
                    i++;
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Listar.this, android.R.layout.simple_list_item_1, produc);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(Listar.this, "Lectura fallida", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
