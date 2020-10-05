package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.illidan.R;
import com.example.inventario.entity.Producto;

public class DetalleProducto extends AppCompatActivity {
    private EditText codigo,fecha,cantidad,precio,nombre,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        codigo = (EditText) findViewById(R.id.dtcodigo);
        fecha = (EditText) findViewById(R.id.dtfecha);
        cantidad = (EditText) findViewById(R.id.dtcantidad);
        precio = (EditText) findViewById(R.id.dtprecio);
        nombre = (EditText) findViewById(R.id.dtnombre);
        descripcion = (EditText) findViewById(R.id.dtdetalle);
        Bundle object = getIntent().getExtras();
        if(object != null){
            Producto producto = (Producto) object.getSerializable("producto");
            codigo.setText(producto.getCodigo());
            fecha.setText(producto.getFecha());
            cantidad.setText(producto.getCantidad().toString());
            precio.setText(producto.getPrecio().toString());
            nombre.setText(producto.getNombre());
            descripcion.setText(producto.getDescripcion());
        }
    }
}