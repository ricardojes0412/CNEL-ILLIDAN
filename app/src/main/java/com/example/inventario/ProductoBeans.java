package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.illidan.R;
import com.example.inventario.entity.Categoria;
import com.example.inventario.sqliteConexion.ConexionSqliteOpenHelper;
import com.example.inventario.utils.Utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ProductoBeans extends AppCompatActivity {

    private Spinner listaTipo;
    private Button guardar_prod,cancelarProd;
    private EditText marca,nombre,descripcion,fecha,precio,cantidad;
    private Calendar calendario;
    private ConexionSqliteOpenHelper con;
    private ArrayList<String> listCategoria;
    private ArrayList<Categoria> categoriaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        con = new ConexionSqliteOpenHelper(this);
        listaTipo = (Spinner) findViewById(R.id.listaTipoInve);
        fecha = (EditText) findViewById(R.id.fechaRegPro);
        marca = (EditText) findViewById(R.id.marcaProducto);
        nombre = (EditText) findViewById(R.id.nombre_prod);
        descripcion = (EditText) findViewById(R.id.descripcion_prod);
        precio = (EditText) findViewById(R.id.editTextNumberPrecio);
        cantidad = (EditText) findViewById(R.id.editTextNumberCantidad);
        calendario = Calendar.getInstance();
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ProductoBeans.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        cargarComboList();
        ArrayAdapter<Character> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listCategoria);
        listaTipo.setAdapter(adapter);
    }

    private void cargarComboList() {
        SQLiteDatabase db = con.getReadableDatabase();
        Categoria cat = null;
        categoriaList = new ArrayList<Categoria>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utils.TABLA_CATEGORIA,null);
        while (cursor.moveToNext()){
            cat = new Categoria();
            cat.setId(cursor.getInt(0));
            cat.setNombre(cursor.getString(1));
            cat.setDescripcion(cursor.getString(2));
            categoriaList.add(cat);
        }
        obtenerlist();
    }

    private void obtenerlist() {
        listCategoria = new ArrayList<String>();
        listCategoria.add("SELECCIONE");
        for(Categoria ct : categoriaList){
            listCategoria.add(ct.getNombre());
        }

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };
    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);
        fecha.setText(sdf.format(calendario.getTime()));
    }
}