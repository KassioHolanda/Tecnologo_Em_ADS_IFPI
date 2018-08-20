package com.android.biblio.biblio.fragments.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterEmprestimosUsuario;
import com.android.biblio.biblio.adapters.AdapterReserva;
import com.android.biblio.biblio.app.LoginActivity;
import com.android.biblio.biblio.models.Categoria;
import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.models.Reserva;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaCategoriaAPIModel;
import com.android.biblio.biblio.service.ListaReservaAPIModel;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReservasFragment extends Fragment {

    private Mensagens mensagens;
    private APIService apiService;
    private Preferencias preferencias;
    private RecyclerView recyclerViewReservas;
    private Usuario usuarioLogado;
    private List<Titulo> titulos;
    private List<Categoria> categorias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservas, container, false);
//        titulos = new ArrayList<>();
//        categorias = new ArrayList<>();
        setupInit();
        binding(v);
        carregarReservas();
//        carregarTitulos();
//        carregarCategorias();
        return v;
    }


    public void binding(View v) {
        recyclerViewReservas = v.findViewById(R.id.recycler_view_reservas_id);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Minhas Reservas");

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

    public void carregarReservas() {
        Call<Usuario> call = apiService.getUserEndPoint().getUsuario(preferencias.getSavedLong(mensagens.ID_USUARIO));
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                usuarioLogado = response.body();
                if (usuarioLogado.getMinhasReservas().size() == 0) {
                    Toast.makeText(getContext(), "Você não possui reservas...", Toast.LENGTH_SHORT).show();
                }

                if (response.code() == 403) {
                    Toast.makeText(getContext(), "Sessão expirou, faça login novamente...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                atualizaAdapter(usuarioLogado.getMinhasReservas());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getContext(), mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void carregarTitulos() {
//        Call<ListaTitulosAPIModel> call = apiService.getTituloEndPoint().titulos();
//        call.enqueue(new Callback<ListaTitulosAPIModel>() {
//            @Override
//            public void onResponse(Call<ListaTitulosAPIModel> call, Response<ListaTitulosAPIModel> response) {
//                if (response.isSuccessful()) {
//                    titulos = response.body().getResults();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListaTitulosAPIModel> call, Throwable t) {
//
//            }
//        });
//    }

//    public void carregarCategorias() {
//        Call<ListaCategoriaAPIModel> call = apiService.getCategoriaEndPoint().categorias();
//        call.enqueue(new Callback<ListaCategoriaAPIModel>() {
//            @Override
//            public void onResponse(Call<ListaCategoriaAPIModel> call, Response<ListaCategoriaAPIModel> response) {
//                if (response.isSuccessful()) {
//                    categorias = response.body().getResults();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListaCategoriaAPIModel> call, Throwable t) {
//
//            }
//        });
//    }

    public void atualizaAdapter(List<Reserva> reservas) {
        AdapterReserva adapterReserva = new AdapterReserva(getContext(), reservas);
        recyclerViewReservas.setAdapter(adapterReserva);
        recyclerViewReservas.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
