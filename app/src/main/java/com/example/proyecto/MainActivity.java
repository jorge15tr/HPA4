package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editCIP;
    Button btnIng, btnVot;
    boolean a = false;

    ArrayList<id_voto> entidades = new ArrayList<id_voto>();

    private ArrayList<id_voto> rellenador(){
        entidades.add(new id_voto(0, "8-944-327"));
        entidades.add(new id_voto(0, "3-740-1394"));
        entidades.add(new id_voto(0, "20-53-4282"));
        entidades.add(new id_voto(0, "8-943-1867"));
        entidades.add(new id_voto(0, "8-937-503"));
        entidades.add(new id_voto(0, "8-952-2444"));
        entidades.add(new id_voto(0, "8-943-12"));
        entidades.add(new id_voto(0, "8-986-549"));
        entidades.add(new id_voto(0, "8-957-1827"));
        entidades.add(new id_voto(0, "8-940-1311"));
        entidades.add(new id_voto(0, "8-863-1620"));
        entidades.add(new id_voto(0, "8-964-691"));
        entidades.add(new id_voto(0, "8-954-1126"));
        entidades.add(new id_voto(0, "8-1039-1537"));
        entidades.add(new id_voto(0, "8-925-1168"));
        entidades.add(new id_voto(0, "8-940-1505"));
        entidades.add(new id_voto(0, "8-0938-925"));
        entidades.add(new id_voto(0, "3-743-2493"));
        entidades.add(new id_voto(0, "E-8-169755"));
        entidades.add(new id_voto(0, "8-971-1811"));
        entidades.add(new id_voto(0, "8-940-408"));
        entidades.add(new id_voto(0, "8-937-1640"));
        entidades.add(new id_voto(0, "8-939-1578"));
        entidades.add(new id_voto(0, "8-942-1406"));
        entidades.add(new id_voto(0, "6-722-724"));
        entidades.add(new id_voto(0, "8-941-1215"));
        entidades.add(new id_voto(0, "8-962-1218"));
        entidades.add(new id_voto(0, "8-941-924"));
        entidades.add(new id_voto(0, "8-980-2414"));
        entidades.add(new id_voto(0, "3-742-2055"));
        entidades.add(new id_voto(0, "8-942-1192"));
        entidades.add(new id_voto(0, "8-904-1189"));
        entidades.add(new id_voto(0, "8-959-857"));
        entidades.add(new id_voto(0, "8-964-1554"));
        entidades.add(new id_voto(0, "8-1066-1018"));
        entidades.add(new id_voto(0, "8-1055-701"));
        entidades.add(new id_voto(0, "8-970-242"));
        entidades.add(new id_voto(0, "3-752-1461"));
        entidades.add(new id_voto(0, "3-745-950"));
        entidades.add(new id_voto(0, "3-743-1190"));
        entidades.add(new id_voto(0, "8-960-2114"));
        return entidades;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent3 = getIntent();
        a = intent3.getBooleanExtra("valido", false);

        if(a == false) rellenador();
        else entidades = (ArrayList<id_voto>) getIntent().getSerializableExtra("actual");

        editCIP=findViewById(R.id.editCIP);
        btnIng=findViewById(R.id.btnIng);
        btnVot=findViewById(R.id.btnVot);

        btnIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idk = String.valueOf(editCIP.getText().toString());
                boolean vacio = false;
                Intent intent1 = new Intent(getApplicationContext(), Votos.class);

                for(int i = 0; i < entidades.size(); i++){
                    if(idk.equals(entidades.get(i).cip)){
                        if(entidades.get(i).voto != 0){

                            Toast.makeText(getApplicationContext(), "Ud ya Voto", Toast.LENGTH_SHORT).show(); //alert dialog de que ya votó
                            vacio = true;
                            break;
                        }
                        else {
                            intent1.putExtra("numero", i);
                            intent1.putExtra("viaje", entidades);
                            startActivity(intent1);
                            vacio = true;
                            break;
                        }
                    }
                }

                if(!vacio){

                    Toast.makeText(getApplicationContext(), "la cedula no existe", Toast.LENGTH_SHORT).show();//alert dialog de que no existe la cedula ingresada

                }
            }
        });

        btnVot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),Resultados.class);
                int acum1 = 0;
                int acum2 = 0;
                int acum3 = 0;
                for(int i = 0; i < entidades.size(); i++){

                    if(entidades.get(i).voto !=0 ){
                        if(entidades.get(i).voto == 1 ){
                            acum1++;
                        }
                        else if(entidades.get(i).voto == 2 ){
                            acum2++;
                        }
                        else{
                            acum3++;
                        }
                    }
                }
                intent2.putExtra("acumulador1", acum1);
                intent2.putExtra("acumulador2", acum2);
                intent2.putExtra("acumulador3", acum3);
                startActivity(intent2);
            }
        });

    }
}