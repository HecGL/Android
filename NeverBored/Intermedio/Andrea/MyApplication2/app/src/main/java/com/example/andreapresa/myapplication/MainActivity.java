package com.example.andreapresa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Gotodado(View view){
        Intent solicitud = new Intent(this, dado.class);
        startActivity(solicitud);
    }
    public void GototresRayas(View view){
        Intent solicitud = new Intent(this, tresRayas.class);
        startActivity(solicitud);
    }
}
