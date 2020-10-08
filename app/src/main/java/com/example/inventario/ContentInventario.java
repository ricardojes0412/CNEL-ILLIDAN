package com.example.inventario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.Model.Persona;
import com.example.activity.AboutUsActivity;
import com.example.activity.ConfigurationActivity;
import com.example.activity.ProfileActivity;
import com.example.contratos.activitys.RegistroOrdenes;
import com.example.illidan.R;
import com.example.utils.Utils;
import com.google.android.material.navigation.NavigationView;

public class ContentInventario extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private Button btn_categoria, btn_inventario, btn_lista_prov;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private String CREDENTIALS;
    Persona persona = new Persona();

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
        CREDENTIALS = getString(R.string.credentials);


        /*------------- HOOKS-------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*------------- TOOLBAR-------------*/
        setSupportActionBar(toolbar);

        /*------------- NAVIGATION DRAWER MENU -------------*/

        // Hide or show items PARA LOS ROLES SUPONGO XD
        //SI NO ES ADMIN SE OCULTA ESAS OPCIONES
        if (persona.getUser() != null && !persona.getUser().equals(Utils.NOMBRE_ADMIN)) {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.item_orden).setVisible(false);
            menu.findItem(R.id.item_bienes).setVisible(false);
            menu.findItem(R.id.item_responsable).setVisible(false);
        }

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
                startActivity(new Intent(ContentInventario.this, ListaProductos.class));
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

    private void loadPreferences() {
        SharedPreferences preferences = getSharedPreferences(CREDENTIALS, Context.MODE_PRIVATE);
        persona.setUser(preferences.getString(Utils.KEY_USER, ""));
        persona.setNombre(preferences.getString(Utils.KEY_NAME, ""));
        persona.setApellido(preferences.getString(Utils.KEY_LASTNAME, ""));
    }
}