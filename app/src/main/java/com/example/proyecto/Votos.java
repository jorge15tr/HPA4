package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Votos extends AppCompatActivity {

    ArrayList<id_voto> actual = new ArrayList<id_voto>();
    Button btnvotar;
    int pos;
    int vt;
    boolean viaje2;

    RadioButton r1,r2,r3;

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votos);

        Intent intent1 = getIntent();
        pos = intent1.getIntExtra("numero",0);

        actual = (ArrayList<id_voto>) getIntent().getSerializableExtra("viaje");

        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        //--------------------

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.tv);
        r1=findViewById(R.id.rb1);
        r2=findViewById(R.id.rb2);
        r3=findViewById(R.id.rb3);

        Button buttonApply = findViewById(R.id.btnvotar);
        buttonApply.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                textView.setText("Su voto fue para: " + radioButton.getText());

                //*************************
                if( r1.isChecked() ==true ){
                    Toast.makeText(getApplicationContext(), "Ud ah votado por: " + r1.getText().toString(), Toast.LENGTH_SHORT).show();
                    vt = 1;
                }
                else if( r2.isChecked() ==true ){
                    Toast.makeText(getApplicationContext(), "Ud ah votado por: " + r2.getText().toString(), Toast.LENGTH_SHORT).show();
                    vt = 2;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Ud ah votado por: " + r3.getText().toString(), Toast.LENGTH_SHORT).show();
                    vt = 3;
                }
                //*************************

                actual.get(pos).voto = vt;
                viaje2 = true;
                intent2.putExtra("valido", viaje2); //bool
                intent2.putExtra("actual", actual); //array
                startActivity(intent2);

            }
        });
    }


    public void checkButton (View v) {

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Ud ah seleccionado ah: " + radioButton.getText(), Toast.LENGTH_SHORT).show();

    }

}