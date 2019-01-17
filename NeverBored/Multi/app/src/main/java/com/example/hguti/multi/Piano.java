//Funcionalidad del teclado de piano, hecha por Héctor Gutiérrez Li- 15202

package com.example.hguti.multi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Piano extends AppCompatActivity {

    MediaPlayer Csound;
    MediaPlayer Dsound;
    MediaPlayer Esound;
    MediaPlayer Fsound;
    MediaPlayer Gsound;
    MediaPlayer Asound;
    MediaPlayer Bsound;
    MediaPlayer Cplusound;
    MediaPlayer CDsound;
    MediaPlayer DEsound;
    MediaPlayer FGsound;
    MediaPlayer GAsound;
    MediaPlayer ABsound;
    MediaPlayer FurElise;
    MediaPlayer HappyBirthday;
    int hb;
    int fe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        hb=0;
        fe = 0;
        Button c = (Button) findViewById(R.id.CBtn);
        Button d = (Button) findViewById(R.id.DBtn);
        Button e = (Button) findViewById(R.id.EBtn);
        Button f = (Button) findViewById(R.id.FBtn);
        Button g = (Button) findViewById(R.id.GBtn);
        Button a = (Button) findViewById(R.id.ABtn);
        Button b = (Button) findViewById(R.id.BBtn);
        Button cd = (Button) findViewById(R.id.CDBtn);
        Button cplus = (Button) findViewById(R.id.CplusBtn);
        Button de = (Button) findViewById(R.id.DEBtn);
        Button fg = (Button) findViewById(R.id.FGBtn);
        final Button ga = (Button) findViewById(R.id.GABtn);
        Button ab = (Button) findViewById(R.id.ABBtn);
        Button hidden1 = (Button) findViewById(R.id.HiddenBtn1);
        Button hidden2 = (Button) findViewById(R.id.HiddenBtn2);


        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Csound = MediaPlayer.create(Piano.this, R.raw.cnote);
                Csound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Csound) {
                        // TODO Auto-generated method stub
                        Csound.release();
                    }
                });
                Csound.start();
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Dsound = MediaPlayer.create(Piano.this, R.raw.dnote);
                Dsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Dsound) {
                        // TODO Auto-generated method stub
                        Dsound.release();
                    }
                });
                Dsound.start();
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Esound = MediaPlayer.create(Piano.this, R.raw.enote);
                Esound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Esound) {
                        // TODO Auto-generated method stub
                        Esound.release();
                    }
                });
                Esound.start();
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fsound = MediaPlayer.create(Piano.this, R.raw.fnote);
                Fsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Fsound) {
                        // TODO Auto-generated method stub
                        Fsound.release();
                    }
                });
                Fsound.start();
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Gsound = MediaPlayer.create(Piano.this, R.raw.gnote);
                Gsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Gsound) {
                        // TODO Auto-generated method stub
                        Gsound.release();
                    }
                });
                Gsound.start();
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Asound = MediaPlayer.create(Piano.this, R.raw.anote);
                Asound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Asound) {
                        // TODO Auto-generated method stub
                        Asound.release();
                    }
                });
                Asound.start();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bsound = MediaPlayer.create(Piano.this, R.raw.bnote);
                Bsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Bsound) {
                        // TODO Auto-generated method stub
                        Bsound.release();
                    }
                });
                Bsound.start();
            }
        });
        cplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Cplusound = MediaPlayer.create(Piano.this, R.raw.cplus);
                Cplusound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer Cplusound) {
                        // TODO Auto-generated method stub
                        Cplusound.release();
                    }
                });
                Cplusound.start();
            }
        });
        cd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CDsound = MediaPlayer.create(Piano.this, R.raw.cbem);
                CDsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer CDsound) {
                        // TODO Auto-generated method stub
                        CDsound.release();
                    }
                });
                CDsound.start();
            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DEsound = MediaPlayer.create(Piano.this, R.raw.dbem);
                DEsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer DEsound) {
                        // TODO Auto-generated method stub
                        DEsound.release();
                    }
                });
                DEsound.start();
            }
        });
        fg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FGsound = MediaPlayer.create(Piano.this, R.raw.fbem);
                FGsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer FGsound) {
                        // TODO Auto-generated method stub
                        FGsound.release();
                    }
                });
                FGsound.start();
            }
        });
        ga.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GAsound = MediaPlayer.create(Piano.this, R.raw.gbem);
                GAsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer GAsound) {
                        // TODO Auto-generated method stub
                        GAsound.release();
                    }
                });
                GAsound.start();
            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ABsound = MediaPlayer.create(Piano.this, R.raw.abem);
                ABsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer ABsound) {
                        // TODO Auto-generated method stub
                        ABsound.release();
                    }
                });
                ABsound.start();
            }
        });
        hidden1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(fe==0){
                FurElise= MediaPlayer.create(Piano.this, R.raw.furelise);
                FurElise.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer FurElise) {
                        // TODO Auto-generated method stub
                        FurElise.release();
                        fe = 0;
                    }
                });}
                if(fe==0) {
                    FurElise.start();
                    fe = 1;
                }
                else {
                    FurElise.reset();
                    FurElise.stop();
                    FurElise.release();
                    FurElise=null;
                    fe = 0;
                }
            }
        });
        hidden2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(hb==0){
                HappyBirthday = MediaPlayer.create(Piano.this, R.raw.hpbdy);
                HappyBirthday.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer HappyBirthday) {
                        // TODO Auto-generated method stub
                        HappyBirthday.release();
                        hb=0;
                    }
                });}
                if (hb == 0) {
                    HappyBirthday.start();
                    hb = 1;
                } else {
                    HappyBirthday.reset();
                    HappyBirthday.stop();
                    HappyBirthday.release();
                    HappyBirthday=null;
                    hb = 0;
                }
            }
        });
    }
}
