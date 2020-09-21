package com.example.contrato;

import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.illidan.R;
import android.view.View;

public class Contratos extends AppCompatActivity implements View.OnClickListener{

    private Spinner opcionesCiudades;
    private Button guardar;
    private Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratos);
        opcionesCiudades = (Spinner) findViewById(R.id.lisCiudades);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opciones, android.R.layout.simple_spinner_item);
        opcionesCiudades.setAdapter(adapter);
        guardar = (Button)findViewById(R.id.idGuardar);
        cancelar = (Button)findViewById(R.id.idCancelar);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idGuardar:
                anyTaskContratos task = new anyTaskContratos(Contratos.this);
                task.execute("");
                break;
            default:
                Toast.makeText(this, "Accion aun no especificada", Toast.LENGTH_LONG).show();
                break;
        }
    }
}