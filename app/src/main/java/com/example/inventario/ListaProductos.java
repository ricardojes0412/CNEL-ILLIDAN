package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.illidan.R;
import com.example.inventario.entity.Producto;
import com.example.inventario.sqliteConexion.ConexionSqliteOpenHelper;
import com.example.inventario.utils.Utils;

import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity implements View.OnClickListener{

    private ListView listaProductos;
    private ArrayList<String> listaDatos;
    private ArrayList<Producto> listaProducto;
    private ConexionSqliteOpenHelper conex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        listaProductos = (ListView) findViewById(R.id.listaProductos);
        conex = new ConexionSqliteOpenHelper(this);
        consultarProductos();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
        listaProductos.setAdapter(adapter);
        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Producto pro = listaProducto.get(i);
                Intent intent = new Intent(ListaProductos.this,DetalleProducto.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("producto",pro);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v){

    }
    private void consultarProductos() {
        SQLiteDatabase db = conex.getReadableDatabase();
        Producto producto = null;
        listaProducto = new ArrayList<Producto>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utils.TABLA_PRODUCTO,null);
        while (cursor.moveToNext()){
            producto = new Producto();
            producto.setId(cursor.getInt(0));
            producto.setNombre(cursor.getString(1));
            producto.setDescripcion(cursor.getString(2));
            producto.setFecha(cursor.getString(3));
            producto.setMarca(cursor.getString(4));
            producto.setTipo(cursor.getInt(5));
            producto.setCantidad(cursor.getInt(6));
            producto.setPrecio(cursor.getDouble(7));
            producto.setCodigo(cursor.getString(8));
            listaProducto.add(producto);
        }
        obtenerdatos();
    }

    private void obtenerdatos() {
        listaDatos = new ArrayList<String>();
        for(Producto p : listaProducto){
            listaDatos.add("Código: "+p.getCodigo()+" "+"Producto: "+p.getNombre());
        }
    }
}