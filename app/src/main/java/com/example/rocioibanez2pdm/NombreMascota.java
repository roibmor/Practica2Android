package com.example.rocioibanez2pdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NombreMascota extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);
    }

    public void clickActividadNombre(View view) {

        EditText texto = findViewById(R.id.editTextTextPersonName);
        Intent intentNombre = new Intent(NombreMascota.this,MainActivity.class);
        String textoCadena = texto.getText().toString();
        intentNombre.putExtra("pasar_nombre", textoCadena);
        setResult(MainActivity.RESULT_OK, intentNombre);
        Log.d("Nombre:", "Se ha enviado el nombre de la mascota.");
        //startActivity(intentNombre);
        finish();
    }
}
