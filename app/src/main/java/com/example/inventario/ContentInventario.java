package com.example.inventario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.activity.AboutUsActivity;
import com.example.activity.ConfigurationActivity;
import com.example.activity.ProfileActivity;
import com.example.illidan.R;
import com.google.android.material.navigation.NavigationView;

public class ContentInventario extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private Button btn_categoria, btn_inventario, btn_lista_prov;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_inventario);
        btn_categoria = (Button) findViewById(R.id.btn_categoria);
        btn_inventario = (Button) findViewById(R.id.btn_inventario);
        btn_lista_prov = (Button) findViewById(R.id.btn_lista_inv);
        btn_categoria.setOnClickListener(this);
        btn_inventario.setOnClickListener(this);
        btn_lista_prov.setOnClickListener(this);


        /*------------- HOOKS-------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*------------- TOOLBAR-------------*/
        setSupportActionBar(toolbar);

        /*------------- NAVIGATION DRAWER MENU -------------*/

        /* Hide or show items PARA LOS ROLES SUPONGO XD
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_configuration).setVisible(false)*/

        // MUESTRA LA SELECCION EN EL MENU .. DE CADA ITEM
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //ESTABLECER EL ITEM SELECCIONADO  ..
        navigationView.setNavigationItemSelectedListener(this);

        //
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        /// OCUPA TODO EL ALTO DEL CELULAR Y TAMBIEN SI
        // DA ATRAS REGRESA AL MENU, NO SALE DE LA APP
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_categoria:
                startActivity(new Intent(ContentInventario.this, CategoriaBeans.class));
                break;
            case R.id.btn_inventario:
                startActivity(new Intent(ContentInventario.this, ProductoBeans.class));
                break;
            default:
                startActivity(new Intent(ContentInventario.this,ListaProductos.class));
                break;
        }
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
                startActivity(new Intent(ContentInventario.this, ProfileActivity.class));
                break;
            case R.id.nav_about_us:
                startActivity(new Intent(ContentInventario.this, AboutUsActivity.class));
                break;
        }
        //cerrando el drawer en cada seleccion de item
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}