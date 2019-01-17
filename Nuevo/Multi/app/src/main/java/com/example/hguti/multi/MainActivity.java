package com.example.hguti.multi;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        final ImageButton button = findViewById(R.id.Njoy);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                counter ++;
                if (counter ==1){
                Toast toast = Toast.makeText(getApplicationContext(), "Disfruta de la aplicación!", Toast.LENGTH_SHORT);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

            }else if(counter == 20){
                    Toast toast = Toast.makeText(getApplicationContext(), "DEJA DE DARLE A ESTE BOTÓN Y DISFRUTA!!!!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                }else if(counter == 40){
                    Toast toast = Toast.makeText(getApplicationContext(), "Bueno, la aplicación tiene más cosas, pero si lo que te gusta es darle al título, allá tu...", Toast.LENGTH_LONG);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                }else if(counter == 60){
                    Toast toast = Toast.makeText(getApplicationContext(), "Vamos a hacer como si no le hubieras dado 60 veces al botón y volvamos a empezar", Toast.LENGTH_LONG);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    counter=0;
                }
            }
        });
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            button.setImageResource(R.drawable.logo_landscape);
        } else {
            button.setImageResource(R.drawable.logo_portrait);
        }
    }


    public void GotoPiano(View view){
        Intent solicitud = new Intent(this, Piano.class);
        startActivity(solicitud);
    }
    public void GotoCredits(View view){
        Intent solicitud = new Intent(this, Credits.class);
        startActivity(solicitud);
    }
    public void GototresRayas(View view){
        Intent solicitud = new Intent(this, tresRayas.class);
        startActivity(solicitud);
    }
    public void Gotodado(View view){
        Intent solicitud = new Intent(this, dado.class);
        startActivity(solicitud);
    }

    public void Gotocalculator(View view){
        Intent solicitud = new Intent(this, Calculator.class);
        startActivity(solicitud);
    }
}