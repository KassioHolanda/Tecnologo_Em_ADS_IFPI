package com.android.biblio.biblio.fragments.bibliotecario;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterTitulo;
import com.android.biblio.biblio.adapters.AdapterTituloBiblio;
import com.android.biblio.biblio.app.MainActivity;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TitulosFragment extends Fragment {

    private RecyclerView recyclerViewTitulos;
    private FloatingActionButton fabAddTitulo;
    private List<Titulo> listaTitulos;
    private Preferencias preferencias;
    private APIService apiService;
    private Mensagens mensagens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_titulos, container, false);
        binding(view);
        setupInit();
        onClickItem();
        carregarTitulos();
        return view;
    }

    public void onClickItem() {
        fabAddTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                RegistrarTituloFragment registrarTituloFragment = new RegistrarTituloFragment();
                fragmentManager.beginTransaction().replace(R.id.content_biblio, registrarTituloFragment).addToBackStack(null).commit();
            }
        });
    }

    public void binding(View view) {
        recyclerViewTitulos = view.findViewById(R.id.recycler_view_titulos_id);
        fabAddTitulo = view.findViewById(R.id.fab_add_titulo_id);
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Titulos");

    }

    public void carregarTitulos() {
        Call<ListaTitulosAPIModel> call = apiService.getTituloEndPoint().titulos();
        call.enqueue(new Callback<ListaTitulosAPIModel>() {
            @Override
            public void onResponse(Call<ListaTitulosAPIModel> call, Response<ListaTitulosAPIModel> response) {
                if (response.isSuccessful()) {
                    response.body().getResults();
                    atualizarAdapter(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<ListaTitulosAPIModel> call, Throwable t) {

            }
        });
    }

    public void atualizarAdapter(List<Titulo> listaTitulos) {
        AdapterTituloBiblio adapterTitulo = new AdapterTituloBiblio(getContext(), listaTitulos);
        recyclerViewTitulos.setAdapter(adapterTitulo);
        recyclerViewTitulos.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
