package com.example.andreapresa.myapplication;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RandomFragment extends Fragment {
    private TextView texto2;

    public RandomFragment() {
// Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        texto2 = (TextView) view.findViewById(R.id.texto2);
        Button boton1 = (Button) view.findViewById(R.id.boton1);
        Button boton2 = (Button) view.findViewById(R.id.boton2);

        boton1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Random aleatorio = new Random(System.currentTimeMillis());
                // Producir nuevo int aleatorio entre 1 y 6
                int intAletorio =  aleatorio.nextInt(6) + 1;
                aleatorio.setSeed(System.currentTimeMillis());
                texto2.setText(String.valueOf(intAletorio));
            }
        }
        );

        boton2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                texto2.setText("");
                }
        }
        );

        return view;
    }



}
