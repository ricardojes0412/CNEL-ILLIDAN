package com.example.inventario.sqliteConexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSqliteOpenHelper extends SQLiteOpenHelper {

    final static String CREAR_TABLA_CATEGORIA = "CREATE TABLE categoria (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, nombre VARCHAR DEFAULT 350, descripcion TEXT)";
    final static String CREAR_TABLA_PRODUCTO = "CREATE TABLE \"producto\" (\n" +
            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,\n" +
            "\t\"nombre\"\tVARCHAR DEFAULT 350,\n" +
            "\t\"descripcion\"\tTEXT,\n" +
            "\t\"fecha\"\tdate,\n" +
            "\t\"marca\"\tVARCHAR,\n" +
            "\t\"tipo\"\tINTEGER,\n" +
            "\t\"cantidad\"\tINTEGER,\n" +
            "\t\"precio\"\tNUMERIC,\n" +
            "\tFOREIGN KEY(\"tipo\") REFERENCES \"categoria\"(\"id\"))";
    public ConexionSqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREAR_TABLA_CATEGORIA);
    db.execSQL(CREAR_TABLA_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int vesionAntigua, int versionNueva) {

    }
}
