package com.android.biblio.biblio.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.TokenAPI;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaUsersAPIModel;
import com.android.biblio.biblio.utils.FuncionalidadesUteis;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText loginLogin;
    private EditText loginSenha;
    private Button loginAcessar;
    private Button loginRegister;
    private ProgressDialog progressDialog;
    private APIService apiService;
    private Preferencias preferencias;
    private Mensagens mensagens;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding();
        setupInit();
        onClickItem();
        settings();
    }

    public void settings() {
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    public void onClickItem() {
        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegistrarUsuarioActivity.class));
            }
        });

        loginAcessar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario(loginLogin.getText().toString(), loginSenha.getText().toString());
                preferencias.saveString("USERNAME", usuario.getUsername());
                realizarLogin(usuario);
            }
        });
    }

    public void binding() {
        loginLogin = findViewById(R.id.login_login_id);
        loginSenha = findViewById(R.id.login_senha_id);
        loginAcessar = findViewById(R.id.login_acessar_id);
        loginRegister = findViewById(R.id.login_register_id);
    }

    private void setupInit() {
        mensagens = new Mensagens();
        progressDialog = FuncionalidadesUteis.progressDialog(this, mensagens.LOADING);
        apiService = new APIService();
        preferencias = new Preferencias(this);
    }

    private void realizarLogin(final Usuario usuario) {
        progressDialog.show();

        Call<TokenAPI> call = apiService.getTokenEndPointAPI().login(usuario);

        call.enqueue(new Callback<TokenAPI>() {
            @Override
            public void onResponse(Call<TokenAPI> call, Response<TokenAPI> response) {

                if (response.code() == 400) {
                    progressDialog.hide();
                    Toast.makeText(getApplicationContext(), mensagens.INVALID_DATA, Toast.LENGTH_LONG).show();
                }
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    recuperarUsuario();
//                    proxActivityUsuario();
                    preferencias.saveString(mensagens.TOKEN, response.body().getAcess());
//                    Toast.makeText(getApplicationContext(), "" + preferencias.getSavedString("TOKEN"), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TokenAPI> call, Throwable t) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(), "" + mensagens.ERROR_LOGIN, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void logarUsuario(){
        if (usuarioLogado.getTipoUsuario().equals("BIBLIOTECÁRIO")) {
            proxActivityBlibliotecario();
            onStop();
        } else {
            proxActivityUsuario();
            onStop();
        }
    }

    public void proxActivityBlibliotecario() {
        startActivity(new Intent(getApplicationContext(), BiblioDrawerActivity.class));
    }

    public void proxActivityUsuario() {
        startActivity(new Intent(getApplicationContext(), DrawerActivityUser.class));
    }

    public void recuperarUsuario() {
        Call<ListaUsersAPIModel> call = apiService.getUserEndPoint().users();
        call.enqueue(new Callback<ListaUsersAPIModel>() {
            @Override
            public void onResponse(Call<ListaUsersAPIModel> call, Response<ListaUsersAPIModel> response) {
                if(response.isSuccessful()){
                    for (int i = 0; i < response.body().getResults().size(); i++) {
                        if (preferencias.getSavedString("USERNAME").equals(response.body().getResults().get(i).getUsername())) {
                            usuarioLogado = response.body().getResults().get(i);
                            Toast.makeText(getApplicationContext(), "Bem Vindo " + usuarioLogado.getTipoUsuario(), Toast.LENGTH_SHORT).show();
                            preferencias.saveLong("ID_USUARIO", usuarioLogado.getId());
                            logarUsuario();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ListaUsersAPIModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });

    }

}