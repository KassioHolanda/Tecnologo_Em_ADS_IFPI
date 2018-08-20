package com.android.biblio.biblio.app;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.utils.FuncionalidadesUteis;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    private EditText username;
    private EditText senha;
    private EditText email;
    private EditText nome;
    private Spinner tipoUsuario;
    private APIService apiService;
    private Preferencias preferencias;
    ProgressDialog progressDialog;
    private Mensagens mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        binding();
        setupInit();
    }

    public void binding() {
        nome = findViewById(R.id.nome_usuario__register_id);
        username = findViewById(R.id.username_id);
        senha = findViewById(R.id.senha_id);
        email = findViewById(R.id.email_id);
        tipoUsuario = findViewById(R.id.tipo_user_id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void setupInit() {
        mensagens = new Mensagens();
        progressDialog = FuncionalidadesUteis.progressDialog(this, mensagens.LOADING);
        apiService = new APIService();
        preferencias = new Preferencias(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save_id:
                String usernameUsuario = username.getText().toString();
                String emailUsuario = email.getText().toString();
                String nomeUsuario = nome.getText().toString();
                String tipoUsuarioRegistrar = tipoUsuario.getSelectedItem().toString();
                String senhaUsuario = senha.getText().toString();

                Usuario usuario = new Usuario(usernameUsuario, emailUsuario, nomeUsuario, tipoUsuarioRegistrar, senhaUsuario);
                Call<Usuario> call = apiService.getUserEndPoint().postUser(usuario);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Toast.makeText(getApplicationContext(), "" + mensagens.USUARIO_SAVE, Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "" + mensagens.ERROR_SAVE, Toast.LENGTH_SHORT).show();

                    }
                });
        }
        return super.onOptionsItemSelected(item);
    }

    public void tipoUsuario() {
        ArrayAdapter<CharSequence> adapterTipoUsuario = ArrayAdapter.createFromResource(this, R.array.spinner_tipo_usuario, android.R.layout.simple_spinner_item);
        adapterTipoUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoUsuario.setAdapter(adapterTipoUsuario);
    }

    @Override
    protected void onResume() {
        this.tipoUsuario();
        super.onResume();
    }

}
