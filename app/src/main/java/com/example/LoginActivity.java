package com.example;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.illidan.R;
import android.widget.Button;
import com.example.inventario.sqliteConexion.ConexionSqliteOpenHelper;

public class LoginActivity extends AppCompatActivity {
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConexionSqliteOpenHelper con = new ConexionSqliteOpenHelper(this);
        boton=findViewById(R.id.button_session);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Index.class);
                startActivity(intent);
            }
        });
    }

}