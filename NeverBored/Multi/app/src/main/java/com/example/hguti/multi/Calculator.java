//Funcionalidad de la calculadora, hecha por David Luengo Moraleja - 12230



package com.example.hguti.multi;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    // Botones
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private Button botonPlus, botonMinus, botonMult, botonDiv, botonPower;
    private Button  botonPoint, botonC, botonE, botonEqual;

    // Text
    private TextView current_tx, total_tx, oper_tx;

    // Variables
    private double int_aux, total_aux;
    private String int_st, total_st, oper;
    private boolean isPoint; // True si ya se ha pulsado el punto
    private boolean isFirst; // True si es el primer caracter de una secuencia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Orientacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Variables
        //int_aux = 0.0; total_aux = 0.0;
        //int_st = ""; total_st = ""; oper = "";
        isPoint = false;
        isFirst = true;

        //Text
        current_tx = findViewById(R.id.textViewCurrent);
        total_tx = findViewById(R.id.textViewTotal);
        oper_tx = findViewById(R.id.textViewOper);

        //Botones
        boton0 = this.findViewById(R.id.button0);
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("0");
            }
        });
        boton1 = this.findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("1");
            }
        });
        boton2 = this.findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("2");
            }
        });
        boton3 = this.findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("3");
            }
        });
        boton4 = this.findViewById(R.id.button4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("4");
            }
        });
        boton5 = this.findViewById(R.id.button5);
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("5");
            }
        });
        boton6 = this.findViewById(R.id.button6);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("6");
            }
        });
        boton7 = this.findViewById(R.id.button7);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("7");
            }
        });
        boton8 = this.findViewById(R.id.button8);
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("8");
            }
        });
        boton9 = this.findViewById(R.id.button9);
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber("9");
            }
        });
        botonPoint = this.findViewById(R.id.buttonPoint);
        botonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNuber(".");
            }
        });


        botonPlus = this.findViewById(R.id.buttonPlus);
        botonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operate("+");
            }
        });
        botonMinus = this.findViewById(R.id.buttonMinus);
        botonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operate("-");
            }
        });
        botonMult = this.findViewById(R.id.buttonMult);
        botonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operate("x");
            }
        });
        botonDiv = this.findViewById(R.id.buttonDiv);
        botonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operate("/");
            }
        });
        botonPower = this.findViewById(R.id.buttonPower);
        botonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operate("^");
            }
        });


        botonC = this.findViewById(R.id.buttonC);
        botonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clear();
            }
        });
        botonE = this.findViewById(R.id.buttonE);
        botonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Erase();
            }
        });
        botonEqual = this.findViewById(R.id.buttonEqual);
        botonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowResult();
            }
        });
    }


    public void AddNuber(String number){
        if(!isPoint && number.equals(".")){
            isPoint = true;
            String st = current_tx.getText().toString();
            st += number;
            current_tx.setText(st);
        }
        else if(!number.equals(".")){
            String st = current_tx.getText().toString();
            st += number;
            current_tx.setText(st);
        }

    }

    public void Operate(String newoper){

        try {
            //Toma el ultimo operador antes de pulsar
            //Opera con ese y el valor de current_tx y el total
            //Borra current_tx
            //Coloca el nuevo operador
            int_st = current_tx.getText().toString();
            total_st = total_tx.getText().toString();

            if(int_st.equals("")){
                int_st = "0.0";
            }

            if(total_st.equals("")){
                total_st = "0.0";
            }
            int_aux = Double.parseDouble(int_st);
            total_aux = Double.parseDouble(total_st);



            oper = oper_tx.getText().toString();

            switch (oper){
                case "+":
                    total_aux += int_aux;
                    break;
                case "-":
                    total_aux -= int_aux;
                    break;
                case "x":
                    total_aux *= int_aux;
                    break;
                case "/":

                    if(int_aux == 0.0){
                        return;
                    }
                    else{
                        total_aux /= int_aux;
                    }
                    break;
                case "^":
                    total_aux = Math.pow(total_aux, int_aux);
                    break;
                case "":
                    if(isFirst){
                        isFirst = false;
                        total_aux = int_aux;
                    }
                    break;
                default:
                    newoper = "";
                    int_aux = 0.0;
                    int_st = "";
                    oper = "";
                    oper_tx.setText("");
                    current_tx.setText("");
                    break;
            }

            // Poner nuevo operador
            oper = newoper;
            oper_tx.setText(newoper);

            // Poner el resultado
            total_st = Double.toString(total_aux);
            total_tx.setText(total_st);

            // Borrar el current
            current_tx.setText("");
            isPoint = false;

        }catch (Exception e){

            int_aux = 0.0;
            int_st = "";
            oper = "";
            oper_tx.setText("+");
            current_tx.setText("2");
            isPoint = false;
            if(total_aux == 0.0){
                isFirst = true;
            }


        }
    }

    public void Erase(){
        String st = current_tx.getText().toString();
        if(st.length()>0){
            String point_st = st.substring(st.length()-1);
            if (point_st.equals(".")){
                isPoint = false;
            }
            st = st.substring(0, st.length()-1);
            current_tx.setText(st);
        }
    }

    public void Clear(){
        total_tx.setText("");
        oper_tx.setText("");
        current_tx.setText("");

        int_st = "";
        total_st = "";

        int_aux = 0.0;
        total_aux = 0.0;

        isFirst = true;
        isPoint = false;
    }

    public void ShowResult(){
        Operate("");

        current_tx.setText(total_tx.getText().toString());
        total_tx.setText("");
        oper_tx.setText("");

        int_st = "";
        total_st = "";

        int_aux = 0.0;
        total_aux = 0.0;

        isFirst = true;
        isPoint = false;
    }

}

