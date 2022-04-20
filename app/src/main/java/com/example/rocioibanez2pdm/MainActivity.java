package com.example.rocioibanez2pdm;

import static android.util.Log.e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Bundle datos;
    String especieObtenido = null;
    String nombreObtenido = null;
    String edadObtenido = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSalir = (Button) findViewById(R.id.button5);

        /*Button btnEdad = (Button) findViewById(R.id.button3);
        btnEdad.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EdadMascota.class);
                startActivityForResult(intent, 3);
            }
        });*/

        Button btnDatos = (Button) findViewById(R.id.button4);
        btnDatos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*datos = getIntent().getExtras();
                especieObtenido = datos.getString("pasar_especie");
                nombreObtenido = datos.getString("pasar_nombre");
                edadObtenido = datos.getString("pasar_edad");*/

                Intent in = new Intent(MainActivity.this, ImprimirDatos.class);
                in.putExtra("pasar_especie", especieObtenido);
                in.putExtra("pasar_nombre", nombreObtenido);
                in.putExtra("pasar_edad", edadObtenido);

                startActivity(in);
            }
        });

        /*
        buttonMostrar.setOnClickListener {
            val mostrar = Intent(this, Mostrar::class.java)
            mostrar.putExtra("valor_nombre", valor_nombre)
            mostrar.putExtra("valor_apellido", valor_apellido)
            mostrar.putExtra("valor_edad", valor_edad)
            startActivity(mostrar)
        }
        */

    }

    public void clickBtnEspecie (View view) {
        Intent intentEspecie = new Intent(this, EspecieMascota.class);
        startActivityForResult(intentEspecie, 1);
    }

    public void clickBtnNombre(View view) {
        Intent intentNombre = new Intent(this, NombreMascota.class);
        startActivityForResult(intentNombre, 2);
    }

    public void clickBtnEdad(View view) {
        Intent intentEdad = new Intent(this, EdadMascota.class);
        startActivityForResult(intentEdad, 3);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                especieObtenido = data.getExtras().getString("pasar_especie");
            }
        }

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                nombreObtenido = data.getExtras().getString("pasar_nombre");
            }
        }

        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                edadObtenido = data.getExtras().getString("pasar_edad");
            }
        }

    }
}
