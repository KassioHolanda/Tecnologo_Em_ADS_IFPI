package com.android.biblio.biblio.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.app.LoginActivity;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeusDadosFragment extends Fragment {

    private Mensagens mensagens;
    private Preferencias preferencias;
    private APIService apiService;
    private TextView username;
    private TextView email;
    private TextView nome;
    private Button atualizarDados;
    private Usuario usuarioLogado;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meus_dados, container, false);
        setupInit();
        binding(v);
        recuperarUsuarioLogado();
        return v;
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    public void binding(View v) {
        username = v.findViewById(R.id.usuario_username_id);
        nome = v.findViewById(R.id.usuario_nome_id);
        email = v.findViewById(R.id.usuario_email_id);
        atualizarDados = v.findViewById(R.id.usuario_atualizar_id);
    }

    public void recuperarUsuarioLogado() {
        Call<Usuario> call = apiService.getUserEndPoint().getUsuario(preferencias.getSavedLong("ID_USUARIO"));

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.code() == 403) {
                    Toast.makeText(getContext(), "Sessão expirou, faça login novamente...", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getContext(), LoginActivity.class));
                }

                usuarioLogado = response.body();
                atualizarDados();

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    public void atualizarDados() {
        username.setText(usuarioLogado.getUsername());
        nome.setText(usuarioLogado.getNome());
        email.setText(usuarioLogado.getEmail());

        atualizarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioLogado.setUsername(username.getText().toString());
                usuarioLogado.setNome(nome.getText().toString());
                usuarioLogado.setEmail(email.getText().toString());
                Call<Usuario> call = apiService.getUserEndPoint().putUser(usuarioLogado.getId(), usuarioLogado);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Toast.makeText(getContext(), "" + mensagens.DATE_CHANGED, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Meus Dados");
    }

}
