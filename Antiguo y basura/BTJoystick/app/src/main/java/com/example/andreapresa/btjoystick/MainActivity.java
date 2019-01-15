package com.example.andreapresa.btjoystick;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.System.out;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    Context mContext;
    private BluetoothAdapter mBluetoothAdapter;
    private static final int REQUEST_ENABLE_BT = 1;
    private static final String TAG = "SIGN IN FAILED";
    private boolean isConnected = false;
    Button locButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext= MainActivity.this;

       // locButton = (Button) findViewById(R.id.buttonA);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        isBluetoothEnabled();

        //locButton.setOnClickListener(new View.OnClickListener() {
          //  public void onClick(View v) {

                Intent bindIntent = new Intent(mContext, BluetoothActivity.class);
                startService(bindIntent);

         //   }
       // });



    }

    public void isBluetoothEnabled() {

        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "El dispositivo no es válido para esta app", Toast.LENGTH_LONG).show();
        } else if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            isConnected = true;

        }

    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonB:
                if (isConnected && out != null) {
                    out.println("B");
                }
                break;

            case R.id.buttonA:
                if (isConnected && out != null) {
                    out.println("A");
                }
                break;

        }

    }

}