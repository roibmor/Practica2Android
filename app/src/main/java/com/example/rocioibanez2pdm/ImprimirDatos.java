package com.example.rocioibanez2pdm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ImprimirDatos extends AppCompatActivity {

    Bundle datos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir);

        datos = getIntent().getExtras();

        String especieObtenido = datos.getString("pasar_especie");
        String nombreObtenido = datos.getString("pasar_nombre");
        String edadObtenido = datos.getString("pasar_edad");

        TextView cadenaEspecie = findViewById(R.id.textViewEspecie);
        TextView cadenaNombre = findViewById(R.id.textViewNombre);
        TextView cadenaEdad = findViewById(R.id.textViewEdad);

        cadenaEspecie.setText(especieObtenido);
        cadenaNombre.setText(nombreObtenido);
        cadenaEdad.setText(edadObtenido);
    }
}
