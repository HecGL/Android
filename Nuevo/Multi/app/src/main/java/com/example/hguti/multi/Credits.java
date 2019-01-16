package com.example.hguti.multi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Credits extends AppCompatActivity {
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        counter = 0;
    final Button button = (Button) findViewById(R.id.HiddenBtnCredits);
    button.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            counter ++;
            if (counter == 20){
                Toast toast = Toast.makeText(getApplicationContext(), "Also thanks to Pablopjc for his piano idea!", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                counter = 0;
            }
        }
    });
}}
