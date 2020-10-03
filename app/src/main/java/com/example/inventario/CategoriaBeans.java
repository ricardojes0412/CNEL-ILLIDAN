package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.illidan.R;
import com.example.inventario.sqliteConexion.ConexionSqliteOpenHelper;
import com.example.inventario.utils.Utils;

public class CategoriaBeans extends AppCompatActivity implements View.OnClickListener{
    
    private Button btn_guardar;
    private EditText nombre;
    private EditText descripcion;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        btn_guardar = (Button) findViewById(R.id.btn_guardar_categ);
        nombre = (EditText) findViewById(R.id.nombre_categ);
        descripcion = (EditText) findViewById(R.id.descripcion_catg);
        btn_guardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        guardar();
    }

    private void guardar() {
        System.out.println("entro al metodo guardar");
        ConexionSqliteOpenHelper con = new ConexionSqliteOpenHelper(this);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utils.CAMPO_NOMBRE,nombre.getText().toString());
        values.put(Utils.CAMPO_DESCRIPCION,descripcion.getText().toString());
        Long result = db.insert(Utils.TABLA_CATEGORIA,Utils.CAMPO_ID,values);
        limpiar();
        Toast.makeText(this,"Registro :"+result,Toast.LENGTH_SHORT).show();
    }

    public void limpiar(){
        nombre.setText("");
        descripcion.setText("");
    }

}