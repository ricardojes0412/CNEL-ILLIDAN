package com.example.inventario.sqliteConexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.inventario.utils.Utils;

public class ConexionSqliteOpenHelper extends SQLiteOpenHelper {

    public ConexionSqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utils.CREAR_TABLA_CATEGORIA);
        db.execSQL(Utils.CREAR_TABLA_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int vesionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+Utils.TABLA_CATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS "+Utils.TABLA_PRODUCTO);
    }
}
