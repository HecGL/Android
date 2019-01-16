package com.example.hguti.multi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 9;
        final Button button = findViewById(R.id.Njoy);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                counter ++;
                if (counter ==10){
                Toast toast = Toast.makeText(getApplicationContext(), "Disfruta de la aplicación!", Toast.LENGTH_SHORT);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                counter = 0;
            }
            }
        });
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
