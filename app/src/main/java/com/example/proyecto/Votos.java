package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Votos extends AppCompatActivity {
    Button btnvotar;
    ArrayList<id_voto> actualizado = new ArrayList<id_voto>();
    int posicion;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votos);
        btnvotar = findViewById(R.id.btnvotar);

        Intent intent1 = getIntent();
        posicion = intent1.getIntExtra("numero",0);
        actualizado = (ArrayList<id_voto>) getIntent().getSerializableExtra("viaje");

        //btnvotar.enabled

        btnvotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                intent2.putExtra("pos2",posicion);

                boolean cargo = true;

                //validar si ningun rb esta seleccionado usando if(rb.isChecked() == true || ---)
                //las siguientes intrucciones es cuando ya se aprueba el voto (se valido que escogió un rb) y dentro de la opcion OK del alert dialog
                startActivity(intent2);


            }
        });

    }
}