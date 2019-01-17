package com.example.andreapresa.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tresRayas extends AppCompatActivity {

    private int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tres_raya);
        Button casilla11 = (Button) findViewById(R.id.casilla11);
        Button casilla12 = (Button) findViewById(R.id.casilla12);
        Button casilla13 = (Button) findViewById(R.id.casilla13);
        Button casilla21 = (Button) findViewById(R.id.casilla21);
        Button casilla22 = (Button) findViewById(R.id.casilla22);
        Button casilla23 = (Button) findViewById(R.id.casilla23);
        Button casilla31 = (Button) findViewById(R.id.casilla31);
        Button casilla32 = (Button) findViewById(R.id.casilla32);
        Button casilla33 = (Button) findViewById(R.id.casilla33);
        Button newgame = (Button) findViewById(R.id.newgame);

        casilla11.setOnClickListener(new View.OnClickListener() {


                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla11 = (Button) v.findViewById(R.id.casilla11);
                                             if(contador%2==1){
                                                 casilla11.setText("x");} else{
                                                 casilla11.setText("o");
                                             }
                                         }
                                     }
        );

        casilla12.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla12 = (Button) v.findViewById(R.id.casilla12);
                                             if(contador%2==1){
                                                 casilla12.setText("x");} else{
                                                 casilla12.setText("o");
                                             }
                                         }
                                     }
        );

        casilla13.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla13 = (Button) v.findViewById(R.id.casilla13);
                                             if(contador%2==1){
                                                 casilla13.setText("x");} else{
                                                 casilla13.setText("o");
                                             }

                                         }
                                     }
        );

        casilla21.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla21 = (Button) v.findViewById(R.id.casilla21);
                                             if(contador%2==1){
                                                 casilla21.setText("x");} else{
                                                 casilla21.setText("o");
                                             }
                                         }
                                     }
        );

        casilla22.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla22 = (Button) v.findViewById(R.id.casilla22);
                                             if(contador%2==1){
                                                 casilla22.setText("x");} else{
                                                 casilla22.setText("o");
                                             }
                                         }
                                     }
        );

        casilla23.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla23 = (Button) v.findViewById(R.id.casilla23);
                                             if(contador%2==1){
                                                 casilla23.setText("x");} else{
                                                 casilla23.setText("o");
                                             }
                                         }
                                     }
        );
        casilla31.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla31 = (Button) v.findViewById(R.id.casilla31);
                                             if(contador%2==1){
                                                 casilla31.setText("x");} else{
                                                 casilla31.setText("o");
                                             }
                                         }
                                     }
        );

        casilla32.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla32 = (Button) v.findViewById(R.id.casilla32);
                                             if(contador%2==1){
                                                 casilla32.setText("x");} else{
                                                 casilla32.setText("o");
                                             }
                                         }
                                     }
        );

        casilla33.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             contador++;
                                             Button casilla33 = (Button) v.findViewById(R.id.casilla33);
                                             if(contador%2==1){
                                                 casilla33.setText("x");} else{
                                                 casilla33.setText("o");
                                             }
                                         }
                                     }
        );


        newgame.setOnClickListener(new View.OnClickListener() {


                                       public void onClick(View v) {
                                           contador=0;
                                           Button casilla11 = (Button) findViewById(R.id.casilla11);
                                           Button casilla12 = (Button) findViewById(R.id.casilla12);
                                           Button casilla13 = (Button) findViewById(R.id.casilla13);
                                           Button casilla21 = (Button) findViewById(R.id.casilla21);
                                           Button casilla22 = (Button) findViewById(R.id.casilla22);
                                           Button casilla23 = (Button) findViewById(R.id.casilla23);
                                           Button casilla31 = (Button) findViewById(R.id.casilla31);
                                           Button casilla32 = (Button) findViewById(R.id.casilla32);
                                           Button casilla33 = (Button) findViewById(R.id.casilla33);

                                           casilla11.setText("");
                                           casilla12.setText("");
                                           casilla13.setText("");
                                           casilla21.setText("");
                                           casilla22.setText("");
                                           casilla23.setText("");
                                           casilla31.setText("");
                                           casilla32.setText("");
                                           casilla33.setText("");



                                       }
                                   }
        );
    }
}

