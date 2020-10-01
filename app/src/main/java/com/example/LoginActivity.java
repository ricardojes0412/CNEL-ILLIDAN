package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.illidan.R;
import com.example.inventario.sqliteConexion.ConexionSqliteOpenHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConexionSqliteOpenHelper con = new ConexionSqliteOpenHelper(this,"bd_electiva",null,1);
    }
}