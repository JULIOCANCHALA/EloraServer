package com.canchala.julio.eloraserver;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Firebase mRef;
    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitch=(Switch)findViewById(R.id.mySwitch);
        //mySwitch.setChecked(false);

        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://eloraserver.firebaseio.com/");

        final Firebase estado = mRef.child("Estado");

        estado.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = (String) dataSnapshot.getValue();
                mySwitch.setText(text);

                if(text.equals("Abierto"))
                {
                    mySwitch.setChecked(true);

                }
                if(text.equals("Cerrado")){
                    mySwitch.setChecked(false);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


         mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    estado.setValue("Abierto");
                    mySwitch.setTextColor(0xff669900);

                }
                else {
                    estado.setValue("Cerrado");
                    mySwitch.setTextColor(0xffff4444);
                }
            }
        });

    }
}
