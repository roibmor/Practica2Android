package com.example.rocioibanez2pdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EdadMascota extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad);
    }

    public void clickActividadEdad(View view) {

        EditText texto = findViewById(R.id.editTextTextPersonName);
        Intent intentEdad = new Intent(EdadMascota.this,MainActivity.class);
        String textoCadena = texto.getText().toString();
        intentEdad.putExtra("pasar_edad", textoCadena);
        setResult(MainActivity.RESULT_OK, intentEdad);
        Log.d("Edad:", "Se ha enviado la edad de la mascota.");
        startActivity(intentEdad);
    }
}


