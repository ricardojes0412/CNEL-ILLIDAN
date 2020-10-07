package com.example.illidan;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.activity.AboutUsActivity;
import com.example.activity.ConfigurationActivity;
import com.example.activity.ProfileActivity;
import com.example.contratos.activitys.RegistroOrdenes;
import com.example.inventario.ContentInventario;
import com.google.android.material.navigation.NavigationView;

public class Index extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_configuration:
                startActivity(new Intent(this, ConfigurationActivity.class));
                break;
            case R.id.nav_perfil:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.nav_about_us:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;
            case R.id.item_orden:
                startActivity(new Intent(this, RegistroOrdenes.class));
                break;
        }
        //cerrando el drawer en cada seleccion de item
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}