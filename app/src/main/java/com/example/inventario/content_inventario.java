package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.illidan.R;

public class content_inventario extends AppCompatActivity implements View.OnClickListener{
    private Button btn_categoria,btn_inventario,btn_lista_prov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_inventario);
        btn_categoria = (Button)findViewById(R.id.btn_categoria);
        btn_inventario = (Button)findViewById(R.id.btn_inventario);
        btn_lista_prov = (Button)findViewById(R.id.btn_lista_inv);
        btn_categoria.setOnClickListener(this);
        btn_inventario.setOnClickListener(this);
        btn_lista_prov.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        switch (v.getId()){
            case R.id.btn_categoria:
                startActivity(new Intent(this, CategoriaBeans.class));
                break;
            case R.id.btn_inventario:
                startActivity(new Intent(this, ProductoBeans.class));
                    break;
            default:
                break;
        }
    }
}