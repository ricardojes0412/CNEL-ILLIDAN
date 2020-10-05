package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.illidan.R;
import com.example.inventario.entity.Categoria;
import com.example.inventario.sqliteConexion.ConexionSqliteOpenHelper;
import com.example.inventario.utils.Utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProductoBeans extends AppCompatActivity implements View.OnClickListener{

    private Spinner listaTipo;
    private Button guardar_prod,cancelarProd;
    private EditText marca,nombre,descripcion,fecha,precio,cantidad,codigo;
    private Calendar calendario;
    private ConexionSqliteOpenHelper con;
    private ArrayList<String> listCategoria;
    private ArrayList<Categoria> categoriaList;
    private Integer id_categoria;

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
        codigo = (EditText) findViewById(R.id.codigo_pro);
        calendario = Calendar.getInstance();
        guardar_prod = (Button) findViewById(R.id.btn_guardad_prod);
        cancelarProd = (Button) findViewById(R.id.btn_cancelar_reg_prod);
        guardar_prod.setOnClickListener(this);
        cancelarProd.setOnClickListener(this);
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
        listaTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_guardad_prod:
                guardar();
                break;
            default:
                cancelar();
                break;
        }
    }

    public void cancelar(){
        limpiar();
        Intent intent = new Intent(ProductoBeans.this,ContentInventario.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Cancelación Exitosa",Toast.LENGTH_LONG).show();
    }

    private void guardar() {
        if (validaciones()){
            return;
        }
        ConexionSqliteOpenHelper con = new ConexionSqliteOpenHelper(this);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utils.CAMPO_NOMBRE,nombre.getText().toString());
        values.put(Utils.CAMPO_DESCRIPCION,descripcion.getText().toString());
        values.put(Utils.CAMPO_CANTIDAD, Integer.parseInt(cantidad.getText().toString()));
        values.put(Utils.CAMPO_FECHA, fecha.getText().toString());
        values.put(Utils.CAMPO_MARCA,marca.getText().toString());
        values.put(Utils.CAMPO_PRECIO,Double.parseDouble(precio.getText().toString()));
        values.put(Utils.CAMPO_CODIGO,codigo.getText().toString());
        int idcategoria = (int) listaTipo.getSelectedItemId();
        if(idcategoria!=0) {
            id_categoria = categoriaList.get(idcategoria-1).getId();
            values.put(Utils.CAMPO_TIPO,id_categoria);
            Long result = db.insert(Utils.TABLA_PRODUCTO, Utils.CAMPO_ID, values);
            Toast.makeText(this,"Registro con Exito:"+result,Toast.LENGTH_SHORT).show();
            db.close();
        }else{
            Toast.makeText(getApplicationContext(),"Debe Seleccionar un Tipo",Toast.LENGTH_LONG).show();
        }
        limpiar();
    }

    public boolean validaciones(){
        if(Utils.vacio(codigo)){
            return true;
        }
        if(Utils.vacio(nombre)){
            return true;
        }
        if(Utils.vacio(precio)){
            return true;
        }
        if(Utils.vacio(cantidad)){
            return true;
        }
        return false;
    }

    public void limpiar(){
        marca.setText("");
        nombre.setText("");
        descripcion.setText("");
        fecha.setText("");
        precio.setText("");
        cantidad.setText("");
        codigo.setText("");
    }

}