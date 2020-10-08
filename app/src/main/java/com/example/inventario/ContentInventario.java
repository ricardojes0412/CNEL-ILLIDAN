package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Model.Persona;
import com.example.illidan.R;
import com.example.utils.Utils;

public class ContentInventario extends AppCompatActivity implements View.OnClickListener {
    private Button btn_categoria, btn_inventario, btn_lista_prov;
    private String CREDENTIALS;
    Persona persona = new Persona();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_inventario);
        btn_categoria = (Button) findViewById(R.id.btn_categoria);
        btn_inventario = (Button) findViewById(R.id.btn_inventario);
        btn_lista_prov = (Button) findViewById(R.id.btn_lista_inv);
        btn_categoria.setOnClickListener(this);
        btn_inventario.setOnClickListener(this);
        btn_lista_prov.setOnClickListener(this);
        CREDENTIALS = getString(R.string.credentials);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_categoria:
                startActivity(new Intent(ContentInventario.this, CategoriaBeans.class));
                break;
            case R.id.btn_inventario:
                startActivity(new Intent(ContentInventario.this, ProductoBeans.class));
                break;
            default:
                startActivity(new Intent(ContentInventario.this, ListaProductos.class));
                break;
        }
    }

    private void loadPreferences() {
        SharedPreferences preferences = getSharedPreferences(CREDENTIALS, Context.MODE_PRIVATE);
        persona.setUser(preferences.getString(Utils.KEY_USER, ""));
        persona.setNombre(preferences.getString(Utils.KEY_NAME, ""));
        persona.setApellido(preferences.getString(Utils.KEY_LASTNAME, ""));
    }
}