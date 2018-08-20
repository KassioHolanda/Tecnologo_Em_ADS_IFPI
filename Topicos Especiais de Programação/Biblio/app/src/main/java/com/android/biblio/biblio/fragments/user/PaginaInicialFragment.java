package com.android.biblio.biblio.fragments.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterTitulo;
import com.android.biblio.biblio.adapters.AdapterTituloUser;
import com.android.biblio.biblio.app.LoginActivity;
import com.android.biblio.biblio.fragments.bibliotecario.RegistrarTituloFragment;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginaInicialFragment extends Fragment {

    private Mensagens mensagens;
    private Preferencias preferencias;
    private APIService apiService;
    private RecyclerView recyclerViewTitulosUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagina_inicial, container, false);
        binding(view);
        setupInit();
        carregarTitulos();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Pagina Inicial");
    }

    public void binding(View view) {
        recyclerViewTitulosUser = view.findViewById(R.id.recycler_view_titulos_user_id);
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
        return token;
    }

    public void carregarTitulos() {
        Call<ListaTitulosAPIModel> call = apiService.getTituloEndPoint().titulos();
        call.enqueue(new Callback<ListaTitulosAPIModel>() {
            @Override
            public void onResponse(Call<ListaTitulosAPIModel> call, Response<ListaTitulosAPIModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResults().size() == 0) {
                        Toast.makeText(getContext(), "Não ha titulos cadastrados...", Toast.LENGTH_SHORT).show();
                    }

                    if (response.code() == 403) {
                        Toast.makeText(getContext(), "Sessão expirou, faça login novamente...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), LoginActivity.class));
                    }
                    atualizarAdapter(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<ListaTitulosAPIModel> call, Throwable t) {
                Toast.makeText(getContext(), mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void atualizarAdapter(List<Titulo> listaTitulos) {
        AdapterTituloUser adapterTitulo = new AdapterTituloUser(getContext(), listaTitulos);
        recyclerViewTitulosUser.setAdapter(adapterTitulo);
        recyclerViewTitulosUser.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
