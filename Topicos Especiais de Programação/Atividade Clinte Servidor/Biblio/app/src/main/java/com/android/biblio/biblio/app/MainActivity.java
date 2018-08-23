package com.android.biblio.biblio.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterTitulo;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.utils.FuncionalidadesUteis;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private APIService apiService;
    private Preferencias preferencias;
    private Mensagens mensagens;
    private RecyclerView recyclerViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupInit();
        binding();
        settings();
        mostrarTitulos();
    }

    public void binding() {
        recyclerViewHome = findViewById(R.id.recycler_view_home_id);
    }

    private void settings() {
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    private void setupInit() {
        mensagens = new Mensagens();
        progressDialog = FuncionalidadesUteis.progressDialog(this, mensagens.LOADING);
        apiService = new APIService();
        preferencias = new Preferencias(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_login_id:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    public void mostrarTitulos() {
        Call<ListaTitulosAPIModel> call = apiService.getTituloEndPoint().titulos();
        call.enqueue(new Callback<ListaTitulosAPIModel>() {
            @Override
            public void onResponse(Call<ListaTitulosAPIModel> call, Response<ListaTitulosAPIModel> response) {
                atualizarAdapter(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ListaTitulosAPIModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void atualizarAdapter(List<Titulo> listaTitulos) {
        AdapterTitulo adapterTitulo = new AdapterTitulo(getApplicationContext(), listaTitulos);
        recyclerViewHome.setAdapter(adapterTitulo);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

}