package com.example.inventario.utils;

import java.util.Date;

public class Utils {
    //NOMBRE DE BD
    public static final String NOMBRE_DB = "db_electiva";
    //Datos de la tabla Categoria
    public static final String TABLA_CATEGORIA = "categoria";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    //Datos de la Tabla Producto
    public static final String TABLA_PRODUCTO = "producto";
    public static final String CAMPO_FECHA = "fecha";
    public static final String CAMPO_MARCA = "marca";
    public static final String CAMPO_TIPO = "tipo";
    public static final String CAMPO_CANTIDAD = "cantidad";
    public static final String CAMPO_PRECIO = "precio";

    public static final String CREAR_TABLA_CATEGORIA = "CREATE TABLE " +TABLA_CATEGORIA+
            "("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"+CAMPO_NOMBRE+" VARCHAR DEFAULT 350,"+CAMPO_DESCRIPCION+" TEXT)";
    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE " +TABLA_PRODUCTO+
            "("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, "+CAMPO_NOMBRE+" VARCHAR DEFAULT 350,"+CAMPO_DESCRIPCION+" TEXT, " +
            ""+CAMPO_FECHA+" date, "+CAMPO_MARCA+" VARCHAR, "+CAMPO_TIPO+" INTEGER, "+CAMPO_CANTIDAD+" INTEGER, "+CAMPO_PRECIO+" NUMERIC)";
}
