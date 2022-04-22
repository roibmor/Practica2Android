package com.example.rocioibanez2pdm;

import static android.util.Log.e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String especieObtenido = null;
    String nombreObtenido = null;
    String edadObtenido = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSalir = (Button) findViewById(R.id.button5);
        btnSalir.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnDatos = (Button) findViewById(R.id.button4);
        btnDatos.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, ImprimirDatos.class);
                in.putExtra("pasar_especie", especieObtenido);
                in.putExtra("pasar_nombre", nombreObtenido);
                in.putExtra("pasar_edad", edadObtenido);

                startActivity(in);
            }
        });
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
