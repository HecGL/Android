package com.example.hguti.multi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class dado extends AppCompatActivity {

    private TextView texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dado);
        texto2 = (TextView) findViewById(R.id.texto2);
        Button boton1 = (Button) findViewById(R.id.boton1);
        Button boton2 = (Button) findViewById(R.id.boton2);


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
    }
}
