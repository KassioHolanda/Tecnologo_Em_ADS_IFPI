package com.android.biblio.biblio.fragments.bibliotecario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterUsuario;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaUsersAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuariosFragment extends Fragment {

    private APIService apiService;
    private Preferencias preferencias;
    private ListView recyclerViewUsuarios;
    private Mensagens mensagens;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);
        binding(view);
        setupInit();
        carregarUsuarios();
        return view;
    }

    public void binding(View view) {
        recyclerViewUsuarios = view.findViewById(R.id.recycler_view_usuarios_id);
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Usuários");
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }

    public void carregarUsuarios() {
        Call<ListaUsersAPIModel> call = apiService.getUserEndPoint().users();

        call.enqueue(new Callback<ListaUsersAPIModel>() {
            @Override
            public void onResponse(Call<ListaUsersAPIModel> call, Response<ListaUsersAPIModel> response) {
                atualizaAdapter(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ListaUsersAPIModel> call, Throwable t) {
                Toast.makeText(getContext(), ""+mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void atualizaAdapter(List<Usuario> usuarios) {
        ArrayAdapter<Usuario> usuarioArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, usuarios);
        recyclerViewUsuarios.setAdapter(usuarioArrayAdapter);
    }

}
