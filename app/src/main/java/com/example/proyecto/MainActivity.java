package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editNom, editCedu;
    Button btnIng, btnVot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNom=findViewById(R.id.editNom);
        editCedu=findViewById(R.id.editCedu);
        btnIng=findViewById(R.id.btnIng);
        btnVot=findViewById(R.id.btnVot);

        btnIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Votos.class);
            }
        });
        btnVot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),Resultados.class);
            }
        });

    }
}