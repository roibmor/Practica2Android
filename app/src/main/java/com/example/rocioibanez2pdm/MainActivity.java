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
                datos = getIntent().getExtras();
                String especieObtenido = datos.getString("pasar_especie");
                String nombreObtenido = datos.getString("pasar_nombre");
                String edadObtenido = datos.getString("pasar_edad");

                Intent in = new Intent(MainActivity.this, ImprimirDatos.class);
                in.putExtra("pasar_especie", especieObtenido);
                in.putExtra("pasar_nombre", nombreObtenido);
                in.putExtra("pasar_edad", edadObtenido);

                startActivity(in);
            }
        });
    }

    public void clickBtnEspecie (View view) {
        Intent intent = new Intent(this, EspecieMascota.class);
        startActivityForResult(intent, 1);
    }

    public void clickBtnNombre(View view) {
        Intent intent = new Intent(this, NombreMascota.class);
        startActivityForResult(intent, 2);
    }

    public void clickBtnEdad(View view) {
        Intent intent = new Intent(this, EdadMascota.class);
        startActivityForResult(intent, 3);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String pasar_especie = data.getExtras().getString("pasar_especie");
            }
        }

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String pasar_nombre = data.getExtras().getString("pasar_nombre");
            }
        }

        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                String pasar_edad = data.getExtras().getString("pasar_edad");
            }
        }

    }
}
