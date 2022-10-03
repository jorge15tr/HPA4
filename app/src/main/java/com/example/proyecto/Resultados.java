package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ProgressBar ;

public class Resultados extends AppCompatActivity {
    int acum1;
    int acum2;
    int acum3;


    float ac1,ac2,ac3;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    ProgressBar p1, p2, p3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);
        textView3 = findViewById(R.id.tv3);
        textView4 = findViewById(R.id.tv4);
        p1 = ( ProgressBar ) findViewById ( R.id.pb1);
        p2 = ( ProgressBar ) findViewById ( R.id.pb2);
        p3 = ( ProgressBar ) findViewById ( R.id.pb3);

        Intent intent1 = getIntent();
        Intent intent2 = getIntent();
        Intent intent3 = getIntent();

        acum1 = intent1.getIntExtra("acumulador1",0);
        acum2 = intent2.getIntExtra("acumulador2",0);
        acum3 = intent3.getIntExtra("acumulador3",0);

        if (acum1 >= 1) ac1=(float)acum1/(acum1+acum2+acum3)*100;
        if (acum2 >= 1) ac2=(float)acum2/(acum1+acum2+acum3)*100;
        if (acum3 >= 1) ac3=(float)acum3/(acum1+acum2+acum3)*100;

        textView1.setText("votos: "+String.format("%.01f",ac1)+"%");
        textView2.setText("votos: "+String.format("%.01f",ac2)+"%");
        textView3.setText("votos: "+String.format("%.01f",ac3)+"%");

        p1.setMax(acum1+acum2+acum3);
        p1.setProgress ( acum1 ) ;

        p2.setMax(acum1+acum2+acum3);
        p2.setProgress ( acum2 ) ;

        p3.setMax(acum1+acum2+acum3);
        p3.setProgress ( acum3 ) ;



        textView4.setText("Votos totales: " + (acum1+acum2+acum3));

    }
}