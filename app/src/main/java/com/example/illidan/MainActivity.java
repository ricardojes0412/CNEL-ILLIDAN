package com.example.illidan;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.contrato.Contratos;
import com.example.inventario.content_inventario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button IniciarSesion;
    private Button Registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarSesion = (Button)findViewById(R.id.button);
        Registrarse = (Button)findViewById(R.id.button2);
        IniciarSesion.setOnClickListener(this);
        Registrarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                startActivity(new Intent(this, Contratos.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, content_inventario.class));
                break;
            default:
                break;
        }
    }
}