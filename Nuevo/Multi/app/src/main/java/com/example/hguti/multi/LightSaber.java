package com.example.hguti.multi;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LightSaber extends AppCompatActivity {

    // Esta parte crea una nueva actividad que emula el sonido de un sable laser
    // Solo hay un boton que actua de encendido y apagado
    // Se usa el acelerometro. Variables necesarias
    //      Valor del cambio en ac. para ignorar ruido en x,y,z
    //      Valor anterior de la aceleracion en x,y,z
    //      Valor del cambio en ac. para choque

    // Sonidos necesarios
    //      Encendido/apagado
    //      Sonido normal
    //      Movimiento
    //      Choque


    private Button LightIt;     // Boton de encendido/apagado

    private SensorManager mySM;
    private Sensor Acc;
    private SensorEventListener myListener;


    // Variables de aceleracion
    private float prevAccX[], prevAccY[], prevAccZ[];      // Aceleracion previa
    private float meanAccX[], meanAccY[], meanAccZ[];      // Aceleracion previa con ruido atenuado
    private float deltaX, deltaY, deltaZ;
    static float noiseX = 5.0f, noiseY = 5.0f, noiseZ = 5.0f;          // Valor max para ignora el ruido
    static float clashX = 12.0f, clashY = 12.0f, clashZ = 12.0f;          // Valor min para reproducir choque
    private boolean isFirst;

    // Estado de la espada
    private boolean isLighted;

    // Sonidos
    MediaPlayer SaberOn;        // Encendido
    int loc_on;
    MediaPlayer SaberOff;       // Apagado
    int loc_off;
    MediaPlayer SaberHum;       // Estatico
    int loc_hum;
    int hum_stream;
    MediaPlayer SaberWhoosh;    // Balanceo
    int loc_whoosh;
    private boolean isWhoosh;
    MediaPlayer SaberClash;     // Choque
    int loc_clash;
    private boolean isClash;

    SoundPool myPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_saber);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Context con = this;

        // Vector
        prevAccX = new float[3];
        prevAccY = new float[3];
        prevAccZ = new float[3];

        meanAccX = new float[3];
        meanAccY = new float[3];
        meanAccZ = new float[3];

        isWhoosh = false;
        isClash = false;

        isFirst = true;

        loc_on = 1;
        loc_off = 2;
        loc_hum = 3;
        loc_whoosh = 4;
        loc_clash = 5;

        // Sensor
        mySM = (SensorManager)getSystemService(SENSOR_SERVICE);

        PackageManager myPM = this.getPackageManager();     // Chequeamos si existe el acelerometro
        boolean isAcc = myPM.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
        if(isAcc){
            Acc = mySM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            myListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                        OperaAceleracion(event);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
        }
        else return;


        // Boton
        LightIt = findViewById(R.id.light);
        LightIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isLighted){
                    // Encender

                    SaberOn = MediaPlayer.create(LightSaber.this, R.raw.on);
                    SaberOn.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            SaberOn.release();
                        }
                    });

                    SaberHum = MediaPlayer.create(LightSaber.this, R.raw.hum);

                    SaberOn.start();
                    SaberHum.start();
                    SaberHum.setLooping(true);

                    isLighted = true;
                }
                else{
                    // Apagar

                    SaberOff = MediaPlayer.create(LightSaber.this, R.raw.off);
                    SaberOff.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            SaberOff.release();
                        }
                    });

                    SaberHum.stop();
                    SaberOff.start();

                    isLighted = false;
                    isFirst = true;
                }
            }
        });
    }

    public void OperaAceleracion(SensorEvent event){
        // Toma el valor del acelerometro
        // Lo compara con el anterior
        // Si la diferencia es menor que el ruido medio, no se hace nada
        // Si es mayor se hace la media entre las tres ultimas lecturas para obtener
        //  un valor con el ruido disminuido


        float Valores[] = event.values;
        float Xnow = Valores[0];
        float Ynow = Valores[1];
        float Znow = Valores[2];

        if(isFirst){
            // Si es el primero rellena el vector con este valor
            prevAccX[0] = Xnow; meanAccX[0] = Xnow;
            prevAccX[1] = Xnow; meanAccX[1] = Xnow;
            prevAccX[2] = Xnow; meanAccX[2] = Xnow;

            prevAccY[0] = Ynow; meanAccY[0] = Ynow;
            prevAccY[1] = Ynow; meanAccY[1] = Ynow;
            prevAccY[2] = Ynow; meanAccY[2] = Ynow;

            prevAccZ[0] = Znow; meanAccZ[0] = Znow;
            prevAccZ[1] = Znow; meanAccZ[1] = Znow;
            prevAccZ[2] = Znow; meanAccZ[2] = Znow;

            deltaX = 0.0f;
            deltaY = 0.0f;
            deltaZ = 0.0f;

            isFirst = false;
        }

        else{
            prevAccX[2] = prevAccX[1];
            prevAccY[2] = prevAccY[1];
            prevAccZ[2] = prevAccZ[1];

            prevAccX[1] = prevAccX[0];
            prevAccY[1] = prevAccY[0];
            prevAccZ[1] = prevAccZ[0];

            prevAccX[0] = Xnow;
            prevAccY[0] = Ynow;
            prevAccZ[0] = Znow;

            meanAccX[2] = meanAccX[1];
            meanAccY[2] = meanAccY[1];
            meanAccZ[2] = meanAccZ[1];

            meanAccX[1] = meanAccX[0];
            meanAccY[1] = meanAccY[0];
            meanAccZ[1] = meanAccZ[0];

            meanAccX[0] = (prevAccX[2] + prevAccX[1] + prevAccX[0]) / 3;
            meanAccY[0] = (prevAccY[2] + prevAccY[1] + prevAccY[0]) / 3;
            meanAccZ[0] = (prevAccZ[2] + prevAccZ[1] + prevAccZ[0]) / 3;

            deltaX = Math.abs(meanAccX[1] - meanAccX[0]);
            deltaY = Math.abs(meanAccY[1] - meanAccY[0]);
            deltaZ = Math.abs(meanAccZ[1] - meanAccZ[0]);

            if((deltaX > noiseX || deltaY > noiseY || deltaZ > noiseZ) && (deltaX <= clashX && deltaY <= clashY && deltaZ <= clashZ) && isLighted){
                if(!isWhoosh && !isClash){
                    SaberWhoosh = MediaPlayer.create(LightSaber.this, R.raw.swing2);
                    SaberWhoosh.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            isWhoosh = false;
                            SaberWhoosh.release();
                            SaberHum.start();
                        }
                    });
                    isWhoosh = true;
                    SaberHum.pause();
                    SaberWhoosh.start();
                }
            }

            else if((deltaX > clashX || deltaY > clashY || deltaZ > clashZ) && isLighted){
                if(!isClash && !isWhoosh){
                    SaberClash = MediaPlayer.create(LightSaber.this, R.raw.hit2);
                    SaberClash.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            isClash = false;
                            SaberClash.release();
                            SaberHum.start();
                        }
                    });
                    isClash = true;
                    SaberHum.pause();
                    SaberClash.start();
                }
            }
        }
    }


    @Override
    protected void onResume(){
        super.onResume();
        mySM.registerListener(myListener, Acc, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause(){
        super.onPause();
        SaberHum.pause();
    }



}
