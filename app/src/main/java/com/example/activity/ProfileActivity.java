package com.example.activity;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.illidan.R;
import com.example.inventario.CategoriaBeans;
import com.example.inventario.ContentInventario;
import com.example.inventario.ListaProductos;
import com.example.inventario.ProductoBeans;
import com.example.utils.Utils;
import com.google.android.material.navigation.NavigationView;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    ///MENU
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private TextView textView_User;
    private TextView textView_Name;
    private TextView textView_Apellido;
    private String CREDENTIALS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView_User = findViewById(R.id.text_view_user);
        textView_Name = findViewById(R.id.text_view_name);
        textView_Apellido = findViewById(R.id.text_view_apellido);
        CREDENTIALS = getString(R.string.credentials);

        loadPreferences();

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
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                startActivity(new Intent(this, ContentInventario.class));
                break;
            case R.id.nav_configuration:
                startActivity(new Intent(this, ConfigurationActivity.class));
                break;
            case R.id.nav_perfil: //ES ESTE ACTIVITY
                break;
            case R.id.nav_about_us:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;
        }
        //cerrando el drawer en cada seleccion de item
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadPreferences() {
        SharedPreferences preferences = getSharedPreferences(CREDENTIALS, Context.MODE_PRIVATE);
        textView_User.setText(preferences.getString(Utils.KEY_USER, ""));
        textView_Name.setText(preferences.getString(Utils.KEY_NAME, ""));
        textView_Apellido.setText(preferences.getString(Utils.KEY_LASTNAME, ""));
    }
}