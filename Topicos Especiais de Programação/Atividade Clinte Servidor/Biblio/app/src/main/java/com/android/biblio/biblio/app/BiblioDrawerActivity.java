package com.android.biblio.biblio.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.fragments.MeusDadosFragment;
import com.android.biblio.biblio.fragments.bibliotecario.EditorasFragment;
import com.android.biblio.biblio.fragments.bibliotecario.EmprestimosBiblioFragment;
import com.android.biblio.biblio.fragments.bibliotecario.TitulosFragment;
import com.android.biblio.biblio.fragments.bibliotecario.UsuariosFragment;
import com.android.biblio.biblio.fragments.user.EmprestimosFragment;
import com.android.biblio.biblio.fragments.user.PaginaInicialFragment;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.prefs.PreferenceChangeEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BiblioDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Preferencias preferencias;
    private APIService apiService;
    private Mensagens mensagens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblio_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mensagens = new Mensagens();
        preferencias = new Preferencias(getApplicationContext());
        apiService = new APIService();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_biblio, new TitulosFragment());
        tx.commit();

//        recuperarUsuario();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;
        switch (itemId) {
            case R.id.titulos_adm_id:
                fragment = new TitulosFragment();
                break;
            case R.id.editoras_adm_id:
                fragment = new EditorasFragment();
                break;
            case R.id.emprestimos_adm_id:
                fragment = new EmprestimosBiblioFragment();
                break;
            case R.id.usuario_adm_id:
                fragment = new UsuariosFragment();
                break;
            case R.id.meus_dados_id:
                fragment = new MeusDadosFragment();
                break;
            case R.id.sair_adm_id:
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }


        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_biblio, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

}
