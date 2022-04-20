package com.example.rocioibanez2pdm;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class EspecieMascota extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especie);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButton:
                if (checked) {
                    Log.d("Perro:", "La mascota es un perro.");
                    break;
                }
            case R.id.radioButton2:
                if (checked) {
                    Log.d("Gato:", "La mascota es un gato.");
                    break;
                }
            case R.id.radioButton3:
                if (checked) {
                    Log.d("Otros:", "La mascota no es un perro ni un gato.");
                    break;
                }
        }
    }

    public void clickActividadEspecie(View view) {

        String textoCadena = null;
        RadioButton rbPerro = findViewById(R.id.radioButton);
        RadioButton rbGato = findViewById(R.id.radioButton2);
        RadioButton rbOtros = findViewById(R.id.radioButton3);

        if (rbPerro.isChecked())
            textoCadena = rbPerro.getText().toString();
        else{
            if (rbGato.isChecked())
                textoCadena = rbGato.getText().toString();
            else{
                if (rbOtros.isChecked())
                    textoCadena = rbOtros.getText().toString();
                }

            }

        Log.d("cadena:", textoCadena);
        Intent intentEspecie = new Intent(EspecieMascota.this,MainActivity.class);
        intentEspecie.putExtra("pasar_especie", textoCadena);
        setResult(MainActivity.RESULT_OK, intentEspecie);
        Log.d("Especie:", "Se ha enviado la especie de la mascota.");
        startActivity(intentEspecie);
    }
}

