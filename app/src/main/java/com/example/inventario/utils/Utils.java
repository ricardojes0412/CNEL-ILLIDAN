package com.example.inventario.utils;

public class Utils {
    //Datos de la tabla Categoria
    public static final String TABLA_CATEGORIA = "categoria";
    //Datos de la Tabla Producto
    public static final String TABLA_PRODUCTO = "producto";

    public static final String CREAR_TABLA_CATEGORIA = "CREATE TABLE categoria " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, nombre VARCHAR DEFAULT 350, descripcion TEXT)";
    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE producto " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, nombre VARCHAR DEFAULT 350,descripcion TEXT, " +
            "fecha date, marca VARCHAR, tipo INTEGER, cantidad INTEGER, precio NUMERIC, FOREIGN KEY(tipo) REFERENCES categoria(id))";
}
